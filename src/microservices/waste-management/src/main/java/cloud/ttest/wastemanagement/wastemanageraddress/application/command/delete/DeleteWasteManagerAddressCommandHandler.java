package cloud.ttest.wastemanagement.wastemanageraddress.application.command.delete;

import cloud.ttest.share.core.domain.bus.command.ICommandHandler;
import cloud.ttest.wastemanagement.wastemanageraddress.domain.WasteManagerAddress;
import cloud.ttest.wastemanagement.wastemanageraddress.domain.service.IWasteManagerAddressDomainService;
import org.springframework.stereotype.Component;

@Component
public class DeleteWasteManagerAddressCommandHandler implements ICommandHandler<DeleteWasteManagerAddressCommand> {

    private final IWasteManagerAddressDomainService wasteManagerAddressDomainService;

    public DeleteWasteManagerAddressCommandHandler(IWasteManagerAddressDomainService wasteManagerAddressDomainService) {
        this.wasteManagerAddressDomainService = wasteManagerAddressDomainService;
    }


    @Override
    public void handle(DeleteWasteManagerAddressCommand command) {
        WasteManagerAddress toDelete = wasteManagerAddressDomainService.findById(command.getId());
        wasteManagerAddressDomainService.delete(toDelete);
    }
}
