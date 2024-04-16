package cloud.ttest.wastemanagement.wastemanager.infrastructure.adapter.service.http;

import java.util.List;

public class WasteCenterAuthRequest {

    private final List<Long> ids;

    public WasteCenterAuthRequest(List<Long> ids) {
        this.ids = ids;
    }

    public List<Long> getIds() {
        return ids;
    }

}
