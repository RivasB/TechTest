package cloud.ttest.wastemanagement.wastemanager.application.command.update;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.util.List;

public class UpdateWasteManagerRequest {

    @NotBlank(message = "ID can not be empty")
    @NotNull(message = "ID is required")
    private final Long id;
    private final String name;
    private final String nif;
    private final String address;
    private final List<Long> wasteCenterAuthorizationNumbers;
    private final Boolean isEnabled;

    public UpdateWasteManagerRequest(Long id, String name, String nif, String address,
                                     List<Long> wasteCenterAuthorizationNumbers, Boolean isEnabled) {
        this.id = id;
        this.name = name;
        this.nif = nif;
        this.address = address;
        this.wasteCenterAuthorizationNumbers = wasteCenterAuthorizationNumbers;
        this.isEnabled = isEnabled;
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

    public String getAddress() {
        return address;
    }

    public List<Long> getWasteCenterAuthorizationNumbers() {
        return wasteCenterAuthorizationNumbers;
    }

    public Boolean getEnabled() {
        return isEnabled;
    }
}
