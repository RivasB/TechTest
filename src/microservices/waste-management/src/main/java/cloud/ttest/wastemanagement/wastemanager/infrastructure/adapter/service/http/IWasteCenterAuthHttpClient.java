package cloud.ttest.wastemanagement.wastemanager.infrastructure.adapter.service.http;

import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface IWasteCenterAuthHttpClient {
    List<String> authorizationNumbers(List<Long> idList);
}
