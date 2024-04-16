package cloud.ttest.wastecenterauth.wastecenterauthorization.application;

import cloud.ttest.share.core.domain.bus.query.IResponse;
import cloud.ttest.wastecenterauth.wastecenterauthorization.domain.WasteCenterAuthorization;
import cloud.ttest.wastecenterauth.wastecenterauthorization.infrastructure.repository.hibernate.WasteCenterAuthorizationEntity;

public class WasteCenterAuthorizationResponse implements IResponse {

    private final Long id;
    private final String authorizationNumber;

    public WasteCenterAuthorizationResponse(WasteCenterAuthorization aggregate) {
        this.id = aggregate.getId();
        this.authorizationNumber = aggregate.getAuthorizationNumber();
    }

    public WasteCenterAuthorizationResponse(WasteCenterAuthorizationEntity entity) {
        this.id = entity.getId();
        this.authorizationNumber = entity.getAuthorizationNumber();
    }

    public Long getId() {
        return id;
    }

    public String getAuthorizationNumber() {
        return authorizationNumber;
    }
}
