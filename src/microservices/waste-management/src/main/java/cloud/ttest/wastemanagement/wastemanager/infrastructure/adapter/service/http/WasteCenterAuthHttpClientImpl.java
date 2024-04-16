package cloud.ttest.wastemanagement.wastemanager.infrastructure.adapter.service.http;

import cloud.ttest.wastemanagement.wastemanager.infrastructure.exception.HttpClientErrorException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class WasteCenterAuthHttpClientImpl implements IWasteCenterAuthHttpClient {

    private static final Logger logger = LoggerFactory.getLogger(WasteCenterAuthHttpClientImpl.class);

    private final IWasteCenterAuthFeignClient feignClient;

    public WasteCenterAuthHttpClientImpl(IWasteCenterAuthFeignClient feignClient) {
        this.feignClient = feignClient;
    }


    @Override
    public List<String> authorizationNumbers(List<Long> idList) {
        try {
            WasteCenterAuthRequest request = new WasteCenterAuthRequest(idList);
            WasteCenterAuthResponse response = feignClient.callGetAuthNumbers(request);
            return response.getAuthNumbers();
        }
        catch(Exception e){
            logger.error(String.format("Unable to get authorization numbers. %s ",e.getMessage()));
            return new ArrayList<>();
        }
    }
}
