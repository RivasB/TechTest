package cloud.ttest.wastecenterauth.wastecenterauthorization.application.query.getbylist;

import java.util.List;

public class GetByListWasteCenterAuthorizationRequest {

    private final List<Long> ids;

    public GetByListWasteCenterAuthorizationRequest(List<Long> ids) {
        this.ids = ids;
    }

    public List<Long> getIds() {
        return ids;
    }

}
