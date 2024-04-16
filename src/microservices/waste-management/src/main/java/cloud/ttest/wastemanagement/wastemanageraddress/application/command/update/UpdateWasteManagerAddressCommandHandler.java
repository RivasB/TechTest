package cloud.ttest.wastemanagement.wastemanageraddress.application.command.update;

import cloud.ttest.share.core.domain.bus.command.ICommandHandler;
import cloud.ttest.wastemanagement.wastemanageraddress.domain.WasteManagerAddress;
import cloud.ttest.wastemanagement.wastemanageraddress.domain.service.IWasteManagerAddressDomainService;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;


@Component
public class UpdateWasteManagerAddressCommandHandler implements ICommandHandler<UpdateWasteManagerAddressCommand> {


    private final IWasteManagerAddressDomainService wasteManagerAddressDomainService;

    public UpdateWasteManagerAddressCommandHandler(IWasteManagerAddressDomainService wasteManagerAddressDomainService) {
        this.wasteManagerAddressDomainService = wasteManagerAddressDomainService;
    }


    @Override
    @Transactional
    public void handle(UpdateWasteManagerAddressCommand command) {
        WasteManagerAddress toUpdate = wasteManagerAddressDomainService.findById(command.getId());
        String address = command.getAddress() != null ? command.getAddress() : toUpdate.getAddress();
        Boolean updatedIsEnabled = command.getEnabled() != null ? command.getEnabled() : toUpdate.getEnabled();
        WasteManagerAddress updated = new WasteManagerAddress(command.getId(), address, updatedIsEnabled);
        wasteManagerAddressDomainService.update(updated);
    }
}
