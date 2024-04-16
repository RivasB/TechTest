package cloud.ttest.wastemanagement.wastemanager.application.query.getbyid;

import cloud.ttest.share.core.domain.bus.query.IQuery;

public class GetByIdWasteManagerQuery implements IQuery {
    private final Long id;

    public GetByIdWasteManagerQuery(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }
}
