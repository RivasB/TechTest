package cloud.ttest.share.core.application;

import java.util.List;

public class GetByListWasteCenterAuthorizationRequest {

    private List<Long> ids;

    public GetByListWasteCenterAuthorizationRequest() {
    }

    public GetByListWasteCenterAuthorizationRequest(List<Long> ids) {
        this.ids = ids;
    }

    public List<Long> getIds() {
        return ids;
    }

}
