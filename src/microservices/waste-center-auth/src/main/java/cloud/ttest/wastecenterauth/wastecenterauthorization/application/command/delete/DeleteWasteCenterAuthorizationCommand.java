package cloud.ttest.wastecenterauth.wastecenterauthorization.application.command.delete;

import cloud.ttest.share.core.domain.bus.command.ICommand;
import cloud.ttest.share.core.domain.bus.command.ICommandMessage;

public class DeleteWasteCenterAuthorizationCommand implements ICommand {
    private final Long id;

    public DeleteWasteCenterAuthorizationCommand(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    @Override
    public ICommandMessage getMessage() {
        return new DeleteWasteCenterAuthorizationMessage();
    }
}
