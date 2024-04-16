package cloud.ttest.wastemanagement.wastemanager.application.command.update;

import cloud.ttest.share.core.domain.bus.command.ICommandMessage;

public class UpdateWasteManagerMessage implements ICommandMessage {

    private final String message;

    public UpdateWasteManagerMessage() {
        this.message = "UPDATED";
    }

    public String getMessage() {
        return message;
    }
}
