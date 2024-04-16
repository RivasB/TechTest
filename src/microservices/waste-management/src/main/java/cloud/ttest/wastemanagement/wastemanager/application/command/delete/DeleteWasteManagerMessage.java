package cloud.ttest.wastemanagement.wastemanager.application.command.delete;

import cloud.ttest.share.core.domain.bus.command.ICommandMessage;

public class DeleteWasteManagerMessage implements ICommandMessage {
    private final String message;

    public DeleteWasteManagerMessage() {
        this.message = "";
    }

    public String getMessage() {
        return message;
    }
}
