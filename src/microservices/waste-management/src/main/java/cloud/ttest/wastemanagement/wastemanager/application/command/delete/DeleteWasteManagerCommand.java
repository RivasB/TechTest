package cloud.ttest.wastemanagement.wastemanager.application.command.delete;

import cloud.ttest.share.core.domain.bus.command.ICommand;
import cloud.ttest.share.core.domain.bus.command.ICommandMessage;

public class DeleteWasteManagerCommand implements ICommand {
    private final Long id;

    public DeleteWasteManagerCommand(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    @Override
    public ICommandMessage getMessage() {
        return new DeleteWasteManagerMessage();
    }
}
