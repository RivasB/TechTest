package cloud.ttest.wastemanagement.wastemanageraddress.infrastructure.exception;

public class WasteManagerAddressNotFoundException extends RuntimeException {

    public WasteManagerAddressNotFoundException() {
        super("Requested Waste Manager Address not found!");
    }

}
