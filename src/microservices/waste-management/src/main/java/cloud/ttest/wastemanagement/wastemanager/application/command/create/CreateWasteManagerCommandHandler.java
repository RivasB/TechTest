package cloud.ttest.wastemanagement.wastemanager.application.command.create;

import cloud.ttest.share.core.domain.bus.command.ICommandHandler;
import cloud.ttest.wastemanagement.wastemanager.domain.WasteManager;
import cloud.ttest.wastemanagement.wastemanager.domain.service.IWasteManagerDomainService;
import cloud.ttest.wastemanagement.wastemanageraddress.domain.WasteManagerAddress;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

@Component
public class CreateWasteManagerCommandHandler implements ICommandHandler<CreateWasteManagerCommand> {

    private final IWasteManagerDomainService wasteManagerDomainService;

    public CreateWasteManagerCommandHandler(IWasteManagerDomainService wasteManagerDomainService) {
        this.wasteManagerDomainService = wasteManagerDomainService;
    }


    @Override
    @Transactional
    public void handle(CreateWasteManagerCommand command) {
        WasteManagerAddress address = new WasteManagerAddress(command.getAddress());
        WasteManager wasteManager = new WasteManager(command.getName(), command.getNif(), address,
                command.getWasteCenterAuthorizationNumbers());
        wasteManagerDomainService.create(wasteManager);
    }
}
