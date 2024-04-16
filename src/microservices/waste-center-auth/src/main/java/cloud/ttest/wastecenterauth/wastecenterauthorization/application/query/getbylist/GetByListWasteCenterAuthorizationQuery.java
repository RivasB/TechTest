package cloud.ttest.wastecenterauth.wastecenterauthorization.application.query.getbylist;

import cloud.ttest.share.core.domain.bus.query.IQuery;

import java.util.List;

public class GetByListWasteCenterAuthorizationQuery implements IQuery {
    private final List<Long> ids;

    public GetByListWasteCenterAuthorizationQuery(List<Long> ids) {
        this.ids = ids;
    }

    public List<Long> getIds() {
        return ids;
    }
}
