package cloud.ttest.share.core.domain.rules;

import cloud.ttest.share.core.domain.exception.DomainErrorMessage;

public abstract class BusinessRule {

    private final DomainErrorMessage error;

    private final String message;

    protected BusinessRule(DomainErrorMessage error, String message) {
        this.error = error;
        this.message = message;
    }

    public abstract boolean isBroken();

    public DomainErrorMessage getError() {
        return error;
    }

    public String getMessage() {
        return message;
    }
}
