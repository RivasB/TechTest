package cloud.ttest.wastemanagement.wastemanageraddress.application.command.create;

import cloud.ttest.share.core.domain.bus.command.ICommandMessage;

public class CreateWasteManagerAddressMessage implements ICommandMessage {
    private final String message;

    public CreateWasteManagerAddressMessage() {
        this.message = "CREATED";
    }

    public String getMessage() {
        return message;
    }
}
