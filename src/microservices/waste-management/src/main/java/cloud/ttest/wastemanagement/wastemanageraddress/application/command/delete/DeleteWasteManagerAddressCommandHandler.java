package cloud.ttest.wastemanagement.wastemanageraddress.application.command.delete;

import cloud.ttest.share.core.domain.bus.command.ICommandHandler;
import cloud.ttest.wastemanagement.wastemanageraddress.domain.WasteManagerAddress;
import cloud.ttest.wastemanagement.wastemanageraddress.domain.service.IWasteManagerAddressDomainService;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

@Component
public class DeleteWasteManagerAddressCommandHandler implements ICommandHandler<DeleteWasteManagerAddressCommand> {

    private final IWasteManagerAddressDomainService wasteManagerAddressDomainService;

    public DeleteWasteManagerAddressCommandHandler(IWasteManagerAddressDomainService wasteManagerAddressDomainService) {
        this.wasteManagerAddressDomainService = wasteManagerAddressDomainService;
    }


    @Override
    @Transactional
    public void handle(DeleteWasteManagerAddressCommand command) {
        WasteManagerAddress toDelete = wasteManagerAddressDomainService.findById(command.getId());
        wasteManagerAddressDomainService.delete(toDelete);
    }
}
