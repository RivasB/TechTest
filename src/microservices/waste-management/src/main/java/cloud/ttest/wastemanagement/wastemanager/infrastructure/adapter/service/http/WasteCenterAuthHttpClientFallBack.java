package cloud.ttest.wastemanagement.wastemanager.infrastructure.adapter.service.http;


import java.util.ArrayList;

public class WasteCenterAuthHttpClientFallBack implements IWasteCenterAuthFeignClient {
    @Override
    public WasteCenterAuthResponse callGetAuthNumbers(WasteCenterAuthRequest request) {
        return new WasteCenterAuthResponse(new ArrayList<>());
    }
}
