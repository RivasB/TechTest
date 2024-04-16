package cloud.ttest.wastecenterauth.wastecenterauthorization.application.command.update;

import cloud.ttest.share.core.domain.bus.command.ICommandHandler;
import cloud.ttest.wastecenterauth.wastecenterauthorization.domain.WasteCenterAuthorization;
import cloud.ttest.wastecenterauth.wastecenterauthorization.domain.service.IWasteCenterAuthorizationDomainService;
import org.springframework.stereotype.Component;


@Component
public class UpdateWasteCenterAuthorizationCommandHandler implements ICommandHandler<UpdateWasteCenterAuthorizationCommand> {


    private final IWasteCenterAuthorizationDomainService wasteCenterAuthorizationDomainService;

    public UpdateWasteCenterAuthorizationCommandHandler(IWasteCenterAuthorizationDomainService wasteCenterAuthorizationDomainService) {
        this.wasteCenterAuthorizationDomainService = wasteCenterAuthorizationDomainService;
    }

    @Override
    public void handle(UpdateWasteCenterAuthorizationCommand command) {
        WasteCenterAuthorization toUpdate = wasteCenterAuthorizationDomainService.findById(command.getId());
        String authorizationNumber = command.getAuthorizationNumber() != null ? command.getAuthorizationNumber() : toUpdate.getAuthorizationNumber();
        WasteCenterAuthorization updated = new WasteCenterAuthorization(command.getId(), authorizationNumber);
        wasteCenterAuthorizationDomainService.update(updated);
    }
}
