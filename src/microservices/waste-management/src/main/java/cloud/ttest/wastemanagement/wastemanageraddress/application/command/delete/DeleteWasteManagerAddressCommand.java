package cloud.ttest.wastemanagement.wastemanageraddress.application.command.delete;

import cloud.ttest.share.core.domain.bus.command.ICommand;
import cloud.ttest.share.core.domain.bus.command.ICommandMessage;

public class DeleteWasteManagerAddressCommand implements ICommand {
    private final Long id;

    public DeleteWasteManagerAddressCommand(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    @Override
    public ICommandMessage getMessage() {
        return new DeleteWasteManagerAddressMessage();
    }
}
