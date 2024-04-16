package cloud.ttest.wastemanagement.wastemanageraddress.application.command.create;

import cloud.ttest.share.core.domain.bus.command.ICommand;
import cloud.ttest.share.core.domain.bus.command.ICommandMessage;

import java.util.ArrayList;
import java.util.List;

public class CreateWasteManagerAddressCommand implements ICommand {
    private final String address;

    public CreateWasteManagerAddressCommand(CreateWasteManagerAddressRequest request){
        this.address = request.getAddress();
    }
    public String getAddress() {
        return address;
    }


    @Override
    public ICommandMessage getMessage() {
        return new CreateWasteManagerAddressMessage();
    }
}
