package cloud.ttest.wastemanagement.wastemanageraddress.application.command.update;

import cloud.ttest.share.core.domain.bus.command.ICommand;
import cloud.ttest.share.core.domain.bus.command.ICommandMessage;


public class UpdateWasteManagerAddressCommand implements ICommand {

    private final Long id;
    private final String address;
    private final Boolean isEnabled;

    public UpdateWasteManagerAddressCommand(UpdateWasteManagerAddressRequest request) {
        this.id = request.getId();
        this.address = request.getAddress() != null ? request.getAddress() : null;
        this.isEnabled = request.getEnabled() != null ? request.getEnabled() : null;
    }

    public Long getId() {
        return id;
    }

    public String getAddress() {
        return address;
    }

    public Boolean getEnabled() {
        return isEnabled;
    }

    @Override
    public ICommandMessage getMessage() {
        return new UpdateWasteManagerAddressMessage();
    }
}
