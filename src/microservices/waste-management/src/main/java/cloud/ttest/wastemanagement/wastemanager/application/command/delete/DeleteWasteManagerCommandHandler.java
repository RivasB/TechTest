package cloud.ttest.wastemanagement.wastemanager.application.command.delete;

import cloud.ttest.share.core.domain.bus.command.ICommandHandler;
import cloud.ttest.wastemanagement.wastemanager.domain.WasteManager;
import cloud.ttest.wastemanagement.wastemanager.domain.service.IWasteManagerDomainService;
import org.springframework.stereotype.Component;

@Component
public class DeleteWasteManagerCommandHandler implements ICommandHandler<DeleteWasteManagerCommand> {

    private final IWasteManagerDomainService wasteManagerDomainService;

    public DeleteWasteManagerCommandHandler(IWasteManagerDomainService wasteManagerDomainService) {
        this.wasteManagerDomainService = wasteManagerDomainService;
    }

    @Override
    public void handle(DeleteWasteManagerCommand command) {
        WasteManager toDelete = wasteManagerDomainService.findById(command.getId());
        wasteManagerDomainService.delete(toDelete);
    }
}
