package cloud.ttest.wastecenterauth.wastecenterauthorization.application.command.update;

import cloud.ttest.share.core.domain.bus.command.ICommand;
import cloud.ttest.share.core.domain.bus.command.ICommandMessage;


public class UpdateWasteCenterAuthorizationCommand implements ICommand {

    private final Long id;
    private final String authorizationNumber;

    public UpdateWasteCenterAuthorizationCommand(UpdateWasteCenterAuthorizationRequest request) {
        this.id = request.getId();
        this.authorizationNumber = request.getAuthorizationNumber() != null ? request.getAuthorizationNumber() : null;
    }

    public Long getId() {
        return id;
    }

    public String getAuthorizationNumber() {
        return authorizationNumber;
    }

    @Override
    public ICommandMessage getMessage() {
        return new UpdateWasteCenterAuthorizationMessage();
    }
}
