package cloud.ttest.wastecenterauth.wastecenterauthorization.application.command.create;

import cloud.ttest.share.core.domain.bus.command.ICommand;
import cloud.ttest.share.core.domain.bus.command.ICommandMessage;


public class CreateWasteCenterAuthorizationCommand implements ICommand {
    private final String authorizationNumber;

    public CreateWasteCenterAuthorizationCommand(CreateWasteCenterAuthorizationRequest request){
        this.authorizationNumber = request.getAuthorizationNumber();
    }
    public String getAuthorizationNumber() {
        return authorizationNumber;
    }


    @Override
    public ICommandMessage getMessage() {
        return new CreateWasteCenterAuthorizationMessage();
    }
}
