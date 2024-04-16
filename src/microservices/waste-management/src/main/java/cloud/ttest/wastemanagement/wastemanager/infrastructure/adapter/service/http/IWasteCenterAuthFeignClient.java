package cloud.ttest.wastemanagement.wastemanager.infrastructure.adapter.service.http;

import cloud.ttest.share.core.application.GetByListWasteCenterAuthorizationRequest;
import cloud.ttest.share.core.application.GetByListWasteCenterAuthorizationResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@FeignClient(name = "waste-center-auth", fallback = WasteCenterAuthHttpClientFallBack.class)
@Component
public interface IWasteCenterAuthFeignClient {

    @RequestMapping(method = RequestMethod.POST, value = "/api/authnumber/list",
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE)
    GetByListWasteCenterAuthorizationResponse callGetAuthNumbers(@RequestBody GetByListWasteCenterAuthorizationRequest request);

}
