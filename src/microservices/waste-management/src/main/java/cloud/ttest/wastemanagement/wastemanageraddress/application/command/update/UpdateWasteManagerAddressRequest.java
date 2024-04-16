package cloud.ttest.wastemanagement.wastemanageraddress.application.command.update;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;


public class UpdateWasteManagerAddressRequest {

    @NotBlank(message = "ID can not be empty")
    @NotNull(message = "ID is required")
    private final Long id;
    private final String address;
    private final Boolean isEnabled;

    public UpdateWasteManagerAddressRequest(Long id, String address, Boolean isEnabled) {
        this.id = id;
        this.address = address;
        this.isEnabled = isEnabled;
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
