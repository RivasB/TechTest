package cloud.ttest.wastecenterauth.wastecenterauthorization.application.command.delete;

import cloud.ttest.share.core.domain.bus.command.ICommandHandler;
import cloud.ttest.wastecenterauth.wastecenterauthorization.domain.WasteCenterAuthorization;
import cloud.ttest.wastecenterauth.wastecenterauthorization.domain.service.IWasteCenterAuthorizationDomainService;
import org.springframework.stereotype.Component;

@Component
public class DeleteWasteCenterAuthorizationCommandHandler implements ICommandHandler<DeleteWasteCenterAuthorizationCommand> {

    private final IWasteCenterAuthorizationDomainService wasteCenterAuthorizationDomainService;

    public DeleteWasteCenterAuthorizationCommandHandler(IWasteCenterAuthorizationDomainService wasteCenterAuthorizationDomainService) {
        this.wasteCenterAuthorizationDomainService = wasteCenterAuthorizationDomainService;
    }


    @Override
    public void handle(DeleteWasteCenterAuthorizationCommand command) {
        WasteCenterAuthorization toDelete = wasteCenterAuthorizationDomainService.findById(command.getId());
        wasteCenterAuthorizationDomainService.delete(toDelete);
    }
}
