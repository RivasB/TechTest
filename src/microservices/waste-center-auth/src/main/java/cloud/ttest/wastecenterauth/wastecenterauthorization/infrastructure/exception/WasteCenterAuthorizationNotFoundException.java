package cloud.ttest.wastecenterauth.wastecenterauthorization.infrastructure.exception;

public class WasteCenterAuthorizationNotFoundException extends RuntimeException {

    public WasteCenterAuthorizationNotFoundException() {
        super("Requested Waste Center Authorization not found!");
    }

}
