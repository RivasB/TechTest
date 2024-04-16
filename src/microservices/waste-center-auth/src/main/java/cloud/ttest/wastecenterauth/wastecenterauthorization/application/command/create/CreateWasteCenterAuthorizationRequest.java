package cloud.ttest.wastecenterauth.wastecenterauthorization.application.command.create;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;


public class CreateWasteCenterAuthorizationRequest {
    @NotBlank(message = "Authorization Number can not be empty")
    @NotNull(message = "Authorization Number is required")
    private String authorizationNumber;

    public CreateWasteCenterAuthorizationRequest() {
    }

    public CreateWasteCenterAuthorizationRequest(String authorizationNumber) {
        this.authorizationNumber = authorizationNumber;
    }

    public String getAuthorizationNumber() {
        return authorizationNumber;
    }
}
