package cloud.ttest.wastecenterauth.wastecenterauthorization.application.command.update;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;


public class UpdateWasteCenterAuthorizationRequest {

    @NotBlank(message = "ID can not be empty")
    @NotNull(message = "ID is required")
    private final Long id;
    private final String authorizationNumber;

    public UpdateWasteCenterAuthorizationRequest(Long id, String authorizationNumber) {
        this.id = id;
        this.authorizationNumber = authorizationNumber;
    }

    public Long getId() {
        return id;
    }


    public String getAuthorizationNumber() {
        return authorizationNumber;
    }

}
