package cloud.ttest.gateway.share.infrastructure.conf;

import cloud.ttest.gateway.share.infrastructure.dto.ExceptionResponse;
import cloud.ttest.gateway.share.infrastructure.dto.ValidateTokenRequest;
import org.springframework.cloud.gateway.filter.GatewayFilter;
import org.springframework.cloud.gateway.filter.factory.AbstractGatewayFilterFactory;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.client.WebClient;
import org.springframework.web.server.ResponseStatusException;

import reactor.core.publisher.Mono;

@Component
public class AuthFilter extends AbstractGatewayFilterFactory<AuthFilter.Config> {

    private final WebClient.Builder webClient;

    public AuthFilter(WebClient.Builder webClient) {
        super(Config.class);
        this.webClient = webClient;
    }

    @Override
    @SuppressWarnings("all")
    public GatewayFilter apply(Config config) {
        return (((exchange, chain) -> {
            if (!exchange.getRequest().getHeaders().containsKey(HttpHeaders.AUTHORIZATION))
                throw new ResponseStatusException(HttpStatus.UNAUTHORIZED, "Authorization header is missing");
            String tokenHeader = exchange.getRequest().getHeaders().get(HttpHeaders.AUTHORIZATION).get(0);
            if (tokenHeader == null) {
                throw new ResponseStatusException(HttpStatus.UNAUTHORIZED, "Token is missing");
            }
            String[] splitedToken = tokenHeader.split(" ");

            if (splitedToken.length != 2 || !splitedToken[0].equals("Bearer"))
                throw new ResponseStatusException(HttpStatus.UNAUTHORIZED, "Malformed token");
            return webClient.build()
                    .post()
                    .uri("lb://identity/api/auth/validate?token=" + splitedToken[1])
                    .retrieve()
                    .onStatus(status -> status.isError(), response -> {
                        return response.bodyToMono(ExceptionResponse.class)
                                .flatMap(error -> Mono.error(
                                        new ResponseStatusException(HttpStatus.UNAUTHORIZED, error.getMessage())));
                    })
                    .bodyToMono(ValidateTokenRequest.class)
                    .map(t -> {
                        return exchange;
                    }).flatMap(chain::filter);
        }));
    }

    public static class Config {
    }
}
