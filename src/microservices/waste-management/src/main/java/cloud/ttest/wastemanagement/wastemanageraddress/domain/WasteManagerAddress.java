package cloud.ttest.wastemanagement.wastemanageraddress.domain;

public class WasteManagerAddress {
    private Long id;
    private final String address;
    private final Boolean isEnabled;

    public WasteManagerAddress(Long id, String address, Boolean isEnabled) {
        this.id = id;
        this.address = address;
        this.isEnabled = isEnabled;
    }

    public WasteManagerAddress(String address) {
        this.address = address;
        this.isEnabled = Boolean.TRUE;
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
