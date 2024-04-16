package cloud.ttest.wastemanagement.wastemanager.infrastructure.exception;

public class HttpClientErrorException extends RuntimeException {

    public HttpClientErrorException() {
        super("Http client communication error!");
    }

}
