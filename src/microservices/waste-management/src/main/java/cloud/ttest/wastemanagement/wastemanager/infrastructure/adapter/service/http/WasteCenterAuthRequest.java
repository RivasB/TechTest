package cloud.ttest.wastemanagement.wastemanager.infrastructure.adapter.service.http;

import java.util.List;

public class WasteCenterAuthRequest {

    private List<Long> ids;


    public WasteCenterAuthRequest() {
    }

    public WasteCenterAuthRequest(List<Long> ids) {
        this.ids = ids;
    }

    public List<Long> getIds() {
        return ids;
    }

}
