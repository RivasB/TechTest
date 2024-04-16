package cloud.ttest.wastemanagement.wastemanager.infrastructure.adapter.service.http;

import java.util.List;

public interface IWasteCenterAuthHttpClient {
    List<String> authorizationNumbers(List<Long> idList);
}
