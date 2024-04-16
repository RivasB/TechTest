package cloud.ttest.wastemanagement.wastemanager.application.command.update;

import cloud.ttest.share.core.domain.bus.command.ICommand;
import cloud.ttest.share.core.domain.bus.command.ICommandMessage;

import java.util.List;

public class UpdateWasteManagerCommand implements ICommand {

    private final Long id;
    private final String name;
    private final String nif;
    private final String address;
    private final List<Long> wasteCenterAuthorizationNumbers;
    private final Boolean isEnabled;

    public UpdateWasteManagerCommand(UpdateWasteManagerRequest request) {
        this.id = request.getId();
        this.name = request.getName() != null ? request.getName() : null;
        this.nif = request.getNif() != null ? request.getNif() : null;
        this.address = request.getAddress() != null ? request.getAddress() : null;
        this.wasteCenterAuthorizationNumbers = request.getWasteCenterAuthorizationNumbers() != null
                ? request.getWasteCenterAuthorizationNumbers() : null;
        this.isEnabled = request.getEnabled() != null ? request.getEnabled() : null;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getNif() {
        return nif;
    }

    public String getAddress() {
        return address;
    }

    public List<Long> getWasteCenterAuthorizationNumbers() {
        return wasteCenterAuthorizationNumbers;
    }

    public Boolean getEnabled() {
        return isEnabled;
    }

    @Override
    public ICommandMessage getMessage() {
        return new UpdateWasteManagerMessage();
    }
}
