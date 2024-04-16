package cloud.ttest.wastemanagement.wastemanager.application.command.create;

import cloud.ttest.share.core.domain.bus.command.ICommandHandler;
import cloud.ttest.wastemanagement.wastemanager.domain.WasteManager;
import cloud.ttest.wastemanagement.wastemanager.domain.service.IWasteManagerDomainService;
import cloud.ttest.wastemanagement.wastemanageraddress.domain.WasteManagerAddress;
import cloud.ttest.wastemanagement.wastemanageraddress.domain.service.IWasteManagerAddressDomainService;
import org.springframework.stereotype.Component;

@Component
public class CreateWasteManagerCommandHandler implements ICommandHandler<CreateWasteManagerCommand> {

    private final IWasteManagerDomainService wasteManagerDomainService;

    private final IWasteManagerAddressDomainService wasteManagerAddressDomainService;

    public CreateWasteManagerCommandHandler(IWasteManagerDomainService wasteManagerDomainService, IWasteManagerAddressDomainService wasteManagerAddressDomainService) {
        this.wasteManagerDomainService = wasteManagerDomainService;
        this.wasteManagerAddressDomainService = wasteManagerAddressDomainService;
    }


    @Override
    public void handle(CreateWasteManagerCommand command) {
        WasteManagerAddress address =
                wasteManagerAddressDomainService.create(new WasteManagerAddress(command.getAddress()));
        WasteManager wasteManager = new WasteManager(command.getName(), command.getNif(), address,
                command.getWasteCenterAuthorizationNumbers());
        wasteManagerDomainService.create(wasteManager);
    }
}
