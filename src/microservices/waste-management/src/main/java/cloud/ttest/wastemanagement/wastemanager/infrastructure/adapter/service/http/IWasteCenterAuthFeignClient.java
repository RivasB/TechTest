package cloud.ttest.wastemanagement.wastemanager.infrastructure.adapter.service.http;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@FeignClient(name = "waste-center-auth", fallback = WasteCenterAuthHttpClientFallBack.class)
@Component
public interface IWasteCenterAuthFeignClient {

    @RequestMapping(method = RequestMethod.GET, value = "/api/authnumber/list")
    WasteCenterAuthResponse callGetAuthNumbers(@RequestBody WasteCenterAuthRequest request);

}
