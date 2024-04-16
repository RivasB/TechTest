package cloud.ttest.wastemanagement.wastemanager.infrastructure.adapter.service.http;

import java.util.List;

public class WasteCenterAuthResponse {
    private final List<String> authNumbers;

    public WasteCenterAuthResponse(List<String> authNumbers) {
        this.authNumbers = authNumbers;
    }

    public List<String> getAuthNumbers() {
        return authNumbers;
    }
}
