package cloud.ttest.wastemanagement.wastemanager.application;

import cloud.ttest.share.core.domain.bus.query.IResponse;
import cloud.ttest.wastemanagement.wastemanager.domain.WasteManager;
import cloud.ttest.wastemanagement.wastemanager.infrastructure.repository.hibernate.WasteManagerEntity;
import cloud.ttest.wastemanagement.wastemanageraddress.application.WasteManagerAddressResponse;

import java.util.List;

public class WasteManagerResponse implements IResponse {
    private final Long id;
    private final String name;
    private final String nif;
    private final WasteManagerAddressResponse address;
    private final List<String> wasteCenterAuthorizationNumbers;
    private final Boolean isEnabled;

    public WasteManagerResponse(List<String> wasteCenterAuthorizationNumbers, WasteManagerEntity entity){
        this.id = entity.getId();
        this.name = entity.getName();
        this.nif = entity.getName();
        this.address = new WasteManagerAddressResponse(entity.getWasteManagerAddress());
        this.wasteCenterAuthorizationNumbers = wasteCenterAuthorizationNumbers;
        this.isEnabled = entity.getEnabled();
    }
    public WasteManagerResponse(List<String> wasteCenterAuthorizationNumbers, WasteManager aggregate){
        this.id = aggregate.getId();
        this.name = aggregate.getName();
        this.nif = aggregate.getName();
        this.address = new WasteManagerAddressResponse(aggregate.getWasteManagerAddress());
        this.wasteCenterAuthorizationNumbers = wasteCenterAuthorizationNumbers;
        this.isEnabled = aggregate.getEnabled();
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getNif() {
        return nif;
    }

    public WasteManagerAddressResponse getAddress() {
        return address;
    }

    public List<String> getWasteCenterAuthorizationNumbers() {
        return wasteCenterAuthorizationNumbers;
    }

    public Boolean getEnabled() {
        return isEnabled;
    }
}
