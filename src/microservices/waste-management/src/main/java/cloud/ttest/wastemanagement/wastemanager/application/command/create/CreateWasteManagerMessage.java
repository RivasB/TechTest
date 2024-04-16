package cloud.ttest.wastemanagement.wastemanager.application.command.create;

import cloud.ttest.share.core.domain.bus.command.ICommandMessage;

public class CreateWasteManagerMessage implements ICommandMessage {
    private final String message;

    public CreateWasteManagerMessage() {
        this.message = "CREATED";
    }

    public String getMessage() {
        return message;
    }
}
