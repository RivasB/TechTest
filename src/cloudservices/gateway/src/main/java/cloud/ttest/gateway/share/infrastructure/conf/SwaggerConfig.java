package cloud.ttest.gateway.share.infrastructure.conf;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.models.Components;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;
import io.swagger.v3.oas.models.servers.Server;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.Arrays;

@Configuration
@OpenAPIDefinition
public class SwaggerConfig {
    @Bean
    public OpenAPI customOpenAPI() {
        return new OpenAPI()
                .components(new Components())
                .servers(Arrays.asList(
                                new Server().url("/waste-management/v3/api-docs").description("Waste Management"),
                                new Server().url("/waste-center-auth/v3/api-docs").description("Waste Center Auth")))
                .info(new Info()
                        .title("Waste Management Cloud API")
                        .description("Documentation Waste Management Cloud API v1.0")
                        .termsOfService("terms")
                        .contact(new Contact().email("@identity.dev"))
                        .license(new License().name("GNU"))
                        .version("v1.0"));
    }
}
