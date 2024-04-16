package cloud.ttest.share.core.application;

import cloud.ttest.share.core.domain.bus.query.IResponse;

import java.util.List;

public class GetByListWasteCenterAuthorizationResponse implements IResponse {
    private List<String> authorizationNumbers;


    public GetByListWasteCenterAuthorizationResponse() {
    }

    public GetByListWasteCenterAuthorizationResponse(List<String> authorizationNumbers) {
        this.authorizationNumbers = authorizationNumbers;
    }

    public List<String> getAuthorizationNumbers() {
        return authorizationNumbers;
    }
}
