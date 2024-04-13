package cloud.ttest.share.core.infrastructure.exceptions;


public class ResourceNotFoundException extends RuntimeException {

    public ResourceNotFoundException(String message) {
        super(message);
    }
}
