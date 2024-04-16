package cloud.ttest.wastemanagement.wastemanager.infrastructure.adapter.service.http;


import cloud.ttest.share.core.application.GetByListWasteCenterAuthorizationRequest;
import cloud.ttest.share.core.application.GetByListWasteCenterAuthorizationResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;

public class WasteCenterAuthHttpClientFallBack implements IWasteCenterAuthFeignClient {

    private static final Logger logger = LoggerFactory.getLogger(WasteCenterAuthHttpClientImpl.class);

    @Override
    public GetByListWasteCenterAuthorizationResponse callGetAuthNumbers(GetByListWasteCenterAuthorizationRequest request) {
        logger.error("Unable to get authorization numbers. Launching FallBack");
        return new GetByListWasteCenterAuthorizationResponse(new ArrayList<>());
    }
}
