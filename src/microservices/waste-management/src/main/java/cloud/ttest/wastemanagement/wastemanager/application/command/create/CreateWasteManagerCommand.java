package cloud.ttest.wastemanagement.wastemanager.application.command.create;

import cloud.ttest.share.core.domain.bus.command.ICommand;
import cloud.ttest.share.core.domain.bus.command.ICommandMessage;

import java.util.ArrayList;
import java.util.List;

public class CreateWasteManagerCommand implements ICommand {
    private final String name;
    private final String nif;
    private final String address;
    private final List<Long> wasteCenterAuthorizationNumbers;
    private final Boolean isEnabled;

    public CreateWasteManagerCommand (CreateWasteManagerRequest request){
        this.name = request.getName();
        this.nif = request.getNif();
        this.address = request.getAddress();
        this.wasteCenterAuthorizationNumbers = request.getWasteCenterAuthorizationNumbers() != null
                ? request.getWasteCenterAuthorizationNumbers() : new ArrayList<>();
        this.isEnabled = Boolean.TRUE;
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
        return new CreateWasteManagerMessage();
    }
}
