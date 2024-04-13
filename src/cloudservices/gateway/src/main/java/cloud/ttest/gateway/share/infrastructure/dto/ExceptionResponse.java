package cloud.ttest.gateway.share.infrastructure.dto;

import java.util.List;

public class ExceptionResponse extends RuntimeException {
    private final String timestamp;

    private final int status;

    private final String message;

    private final List<String> errors;

    private final List<Object> data;

    public ExceptionResponse(String timestamp, int status, String message, List<String> errors, List<Object> data) {
        super(message);
        this.timestamp = timestamp;
        this.status = status;
        this.message = message;
        this.errors = errors;
        this.data = data;
    }

    public String getTimestamp() {
        return timestamp;
    }
    public int getStatus() {
        return status;
    }

    public String getMessage() {
        return message;
    }

    public List<String> getErrors() {
        return errors;
    }

    public List<Object> getData() {
        return data;
    }
}
