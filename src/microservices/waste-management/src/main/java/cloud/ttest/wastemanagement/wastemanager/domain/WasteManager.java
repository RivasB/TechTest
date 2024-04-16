package cloud.ttest.wastemanagement.wastemanager.domain;

import cloud.ttest.wastemanagement.wastemanageraddress.domain.WasteManagerAddress;

import java.util.List;

public class WasteManager {

    private Long id;
    private final String name;
    private final String nif;
    private final WasteManagerAddress wasteManagerAddress;
    private final List<Long> listOfWasteCenterAuthorizationIds;
    private final Boolean isEnabled;

    public WasteManager(Long id, String name, String nif, WasteManagerAddress wasteManagerAddress, List<Long> listOfWasteCenterAuthorizationIds, Boolean isEnabled) {
        this.id = id;
        this.name = name;
        this.nif = nif;
        this.wasteManagerAddress = wasteManagerAddress;
        this.listOfWasteCenterAuthorizationIds = listOfWasteCenterAuthorizationIds;
        this.isEnabled = isEnabled;
    }

    public WasteManager(String name, String nif, WasteManagerAddress wasteManagerAddress, List<Long> listOfWasteCenterAuthorizationIds) {
        this.name = name;
        this.nif = nif;
        this.wasteManagerAddress = wasteManagerAddress;
        this.listOfWasteCenterAuthorizationIds = listOfWasteCenterAuthorizationIds;
        this.isEnabled = Boolean.TRUE;
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

    public WasteManagerAddress getWasteManagerAddress() {
        return wasteManagerAddress;
    }

    public List<Long> getListOfWasteCenterAuthorizationIds() {
        return listOfWasteCenterAuthorizationIds;
    }

    public Boolean getEnabled() {
        return isEnabled;
    }
}
