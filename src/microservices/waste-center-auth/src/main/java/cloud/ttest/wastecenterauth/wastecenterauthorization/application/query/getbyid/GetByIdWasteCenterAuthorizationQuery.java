package cloud.ttest.wastecenterauth.wastecenterauthorization.application.query.getbyid;

import cloud.ttest.share.core.domain.bus.query.IQuery;

public class GetByIdWasteCenterAuthorizationQuery implements IQuery {
    private final Long id;

    public GetByIdWasteCenterAuthorizationQuery(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }
}
