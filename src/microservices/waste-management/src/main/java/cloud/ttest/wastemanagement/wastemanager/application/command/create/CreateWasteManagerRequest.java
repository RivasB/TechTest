package cloud.ttest.wastemanagement.wastemanager.application.command.create;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.util.List;

public class CreateWasteManagerRequest{

    @NotBlank(message = "Name can not be empty")
    @NotNull(message = "Name is required")
    private final String name;

    @NotBlank(message = "NIF can not be empty")
    @NotNull(message = "NIF is required")
    private final String nif;

    @NotBlank(message = "Address can not be empty")
    @NotNull(message = "Address is required")
    private final String address;

    private final List<Long> wasteCenterAuthorizationNumbers;

    public CreateWasteManagerRequest(String name, String nif, String address, List<Long> wasteCenterAuthorizationNumbers) {
        this.name = name;
        this.nif = nif;
        this.address = address;
        this.wasteCenterAuthorizationNumbers = wasteCenterAuthorizationNumbers;
    }

    public String getName() {
        return name;
    }

    public String getNif() {
        return nif;
    }

    public String getAddress() {
        return address;
    }

    public List<Long> getWasteCenterAuthorizationNumbers() {
        return wasteCenterAuthorizationNumbers;
    }
}
