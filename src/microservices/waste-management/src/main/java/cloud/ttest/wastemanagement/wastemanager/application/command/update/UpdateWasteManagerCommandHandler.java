package cloud.ttest.wastemanagement.wastemanager.application.command.update;

import cloud.ttest.share.core.domain.bus.command.ICommandHandler;
import cloud.ttest.wastemanagement.wastemanager.domain.WasteManager;
import cloud.ttest.wastemanagement.wastemanager.domain.service.IWasteManagerDomainService;
import cloud.ttest.wastemanagement.wastemanageraddress.domain.WasteManagerAddress;
import cloud.ttest.wastemanagement.wastemanageraddress.domain.service.IWasteManagerAddressDomainService;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Component
public class UpdateWasteManagerCommandHandler implements ICommandHandler<UpdateWasteManagerCommand> {

    private final IWasteManagerDomainService wasteManagerDomainService;

    private final IWasteManagerAddressDomainService wasteManagerAddressDomainService;

    public UpdateWasteManagerCommandHandler(IWasteManagerDomainService wasteManagerDomainService, IWasteManagerAddressDomainService wasteManagerAddressDomainService) {
        this.wasteManagerDomainService = wasteManagerDomainService;
        this.wasteManagerAddressDomainService = wasteManagerAddressDomainService;
    }


    @Override
    @Transactional
    public void handle(UpdateWasteManagerCommand command) {
        WasteManager toUpdate = wasteManagerDomainService.findById(command.getId());
        String updatedName = command.getName() !=null ? command.getName() : toUpdate.getName();
        String updatedNif = command.getNif() !=null ? command.getNif() : toUpdate.getNif();
        WasteManagerAddress updatedAddress = command.getAddress() != null ?
                new WasteManagerAddress(toUpdate.getWasteManagerAddress().getId(), command.getAddress(),
                        toUpdate.getWasteManagerAddress().getEnabled()) :
                toUpdate.getWasteManagerAddress();
        List<Long> updatedListOfWasteCenterAuthorizationIds = command.getWasteCenterAuthorizationNumbers() != null
                ? command.getWasteCenterAuthorizationNumbers() : toUpdate.getListOfWasteCenterAuthorizationIds();
        Boolean updatedIsEnabled = command.getEnabled() != null ? command.getEnabled() : toUpdate.getEnabled();
        updatedAddress = wasteManagerAddressDomainService.update(updatedAddress);
        WasteManager updated = new WasteManager(toUpdate.getId(),updatedName,updatedNif,updatedAddress,
                updatedListOfWasteCenterAuthorizationIds,updatedIsEnabled);
        wasteManagerDomainService.update(updated);
    }
}
