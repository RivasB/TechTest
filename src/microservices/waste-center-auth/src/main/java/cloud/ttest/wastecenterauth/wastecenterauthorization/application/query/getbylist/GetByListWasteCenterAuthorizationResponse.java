package cloud.ttest.wastecenterauth.wastecenterauthorization.application.query.getbylist;

import cloud.ttest.share.core.domain.bus.query.IResponse;

import java.util.List;

public class GetByListWasteCenterAuthorizationResponse implements IResponse {
    private final List<String> authorizationNumbers;


    public GetByListWasteCenterAuthorizationResponse(List<String> authorizationNumbers) {
        this.authorizationNumbers = authorizationNumbers;
    }

    public List<String> getAuthorizationNumbers() {
        return authorizationNumbers;
    }
}
