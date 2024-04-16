package cloud.ttest.wastecenterauth.wastecenterauthorization.application.command.update;

import cloud.ttest.share.core.domain.bus.command.ICommandMessage;

public class UpdateWasteCenterAuthorizationMessage implements ICommandMessage {

    private final String message;

    public UpdateWasteCenterAuthorizationMessage() {
        this.message = "UPDATED";
    }

    public String getMessage() {
        return message;
    }
}
