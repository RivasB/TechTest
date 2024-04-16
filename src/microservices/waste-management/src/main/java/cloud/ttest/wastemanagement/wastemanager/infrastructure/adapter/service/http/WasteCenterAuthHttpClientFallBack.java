package cloud.ttest.wastemanagement.wastemanager.infrastructure.adapter.service.http;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;

public class WasteCenterAuthHttpClientFallBack implements IWasteCenterAuthFeignClient {

    private static final Logger logger = LoggerFactory.getLogger(WasteCenterAuthHttpClientImpl.class);

    @Override
    public WasteCenterAuthResponse callGetAuthNumbers(WasteCenterAuthRequest request) {
        logger.error("Unable to get authorization numbers. Launching FallBack");
        return new WasteCenterAuthResponse(new ArrayList<>());
    }
}
