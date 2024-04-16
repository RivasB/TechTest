package cloud.ttest.wastecenterauth.wastecenterauthorization.application.command.create;

import cloud.ttest.share.core.domain.bus.command.ICommandMessage;

public class CreateWasteCenterAuthorizationMessage implements ICommandMessage {
    private final String message;

    public CreateWasteCenterAuthorizationMessage() {
        this.message = "CREATED";
    }

    public String getMessage() {
        return message;
    }
}
