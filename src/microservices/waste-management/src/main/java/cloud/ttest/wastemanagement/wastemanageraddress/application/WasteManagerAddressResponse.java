package cloud.ttest.wastemanagement.wastemanageraddress.application;

import cloud.ttest.share.core.domain.bus.query.IResponse;
import cloud.ttest.wastemanagement.wastemanageraddress.domain.WasteManagerAddress;
import cloud.ttest.wastemanagement.wastemanageraddress.infrastructure.repository.hibernate.WasteManagerAddressEntity;

public class WasteManagerAddressResponse implements IResponse {

    private final Long id;
    private final String address;
    private final Boolean isEnabled;


    public WasteManagerAddressResponse(Long id, String address, Boolean isEnabled) {
        this.id = id;
        this.address = address;
        this.isEnabled = isEnabled;
    }

    public WasteManagerAddressResponse(WasteManagerAddress aggregate) {
        this.id = aggregate.getId();
        this.address = aggregate.getAddress();
        this.isEnabled = aggregate.getEnabled();
    }

    public WasteManagerAddressResponse(WasteManagerAddressEntity entity) {
        this.id = entity.getId();
        this.address = entity.getAddress();
        this.isEnabled = entity.getEnabled();
    }

    public Long getId() {
        return id;
    }

    public String getAddress() {
        return address;
    }

    public Boolean getEnabled() {
        return isEnabled;
    }
}
