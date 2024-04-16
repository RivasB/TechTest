package cloud.ttest.wastemanagement.wastemanageraddress.application.command.delete;

import cloud.ttest.share.core.domain.bus.command.ICommandMessage;

public class DeleteWasteManagerAddressMessage implements ICommandMessage {
    private final String message;

    public DeleteWasteManagerAddressMessage() {
        this.message = "";
    }

    public String getMessage() {
        return message;
    }
}
