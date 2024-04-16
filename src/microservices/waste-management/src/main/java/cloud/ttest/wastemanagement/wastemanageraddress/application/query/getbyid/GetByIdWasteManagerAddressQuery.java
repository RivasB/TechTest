package cloud.ttest.wastemanagement.wastemanageraddress.application.query.getbyid;

import cloud.ttest.share.core.domain.bus.query.IQuery;

public class GetByIdWasteManagerAddressQuery implements IQuery {
    private final Long id;

    public GetByIdWasteManagerAddressQuery(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }
}
