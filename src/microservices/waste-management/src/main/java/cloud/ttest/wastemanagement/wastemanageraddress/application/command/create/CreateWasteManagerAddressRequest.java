package cloud.ttest.wastemanagement.wastemanageraddress.application.command.create;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;


public class CreateWasteManagerAddressRequest {
    @NotBlank(message = "Address can not be empty")
    @NotNull(message = "Address is required")
    private final String address;


    public CreateWasteManagerAddressRequest(String address) {
        this.address = address;
    }

    public String getAddress() {
        return address;
    }
}
