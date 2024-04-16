package cloud.ttest.wastemanagement.wastemanager.infrastructure.exception;

public class WasteManagerNotFoundException extends RuntimeException {

    public WasteManagerNotFoundException() {
        super("Requested Waste Manager not found!");
    }

}
