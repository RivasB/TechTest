package cloud.ttest.wastemanagement.wastemanageraddress.application.command.create;

import cloud.ttest.share.core.domain.bus.command.ICommandHandler;
import cloud.ttest.wastemanagement.wastemanageraddress.domain.WasteManagerAddress;
import cloud.ttest.wastemanagement.wastemanageraddress.domain.service.IWasteManagerAddressDomainService;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

@Component
public class CreateWasteManagerAddressCommandHandler implements ICommandHandler<CreateWasteManagerAddressCommand> {


    private final IWasteManagerAddressDomainService wasteManagerAddressDomainService;

    public CreateWasteManagerAddressCommandHandler(IWasteManagerAddressDomainService wasteManagerAddressDomainService) {
        this.wasteManagerAddressDomainService = wasteManagerAddressDomainService;
    }


    @Override
    @Transactional
    public void handle(CreateWasteManagerAddressCommand command) {
        WasteManagerAddress address = new WasteManagerAddress(command.getAddress());
        wasteManagerAddressDomainService.create(address);
    }
}
