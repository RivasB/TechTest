package cloud.ttest.wastecenterauth.wastecenterauthorization.application.command.create;

import cloud.ttest.share.core.domain.bus.command.ICommandHandler;
import cloud.ttest.wastecenterauth.wastecenterauthorization.domain.WasteCenterAuthorization;
import cloud.ttest.wastecenterauth.wastecenterauthorization.domain.service.IWasteCenterAuthorizationDomainService;
import org.springframework.stereotype.Component;

@Component
public class CreateWasteCenterAuthorizationCommandHandler implements ICommandHandler<CreateWasteCenterAuthorizationCommand> {


    private final IWasteCenterAuthorizationDomainService wasteCenterAuthorizationDomainService;

    public CreateWasteCenterAuthorizationCommandHandler(IWasteCenterAuthorizationDomainService wasteCenterAuthorizationDomainService) {
        this.wasteCenterAuthorizationDomainService = wasteCenterAuthorizationDomainService;
    }


    @Override
    public void handle(CreateWasteCenterAuthorizationCommand command) {
        WasteCenterAuthorization wasteCenterAuthorization = new WasteCenterAuthorization(command.getAuthorizationNumber());
        wasteCenterAuthorizationDomainService.create(wasteCenterAuthorization);
    }
}
