package cloud.ttest.wastemanagement.wastemanageraddress.application.command.update;

import cloud.ttest.share.core.domain.bus.command.ICommandMessage;

public class UpdateWasteManagerAddressMessage implements ICommandMessage {

    private final String message;

    public UpdateWasteManagerAddressMessage() {
        this.message = "UPDATED";
    }

    public String getMessage() {
        return message;
    }
}
