package cloud.ttest.wastecenterauth.wastecenterauthorization.application.command.delete;

import cloud.ttest.share.core.domain.bus.command.ICommandMessage;

public class DeleteWasteCenterAuthorizationMessage implements ICommandMessage {
    private final String message;

    public DeleteWasteCenterAuthorizationMessage() {
        this.message = "";
    }

    public String getMessage() {
        return message;
    }
}
