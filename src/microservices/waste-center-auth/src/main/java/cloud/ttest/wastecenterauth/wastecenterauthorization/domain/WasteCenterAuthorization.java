package cloud.ttest.wastecenterauth.wastecenterauthorization.domain;

public class WasteCenterAuthorization {
    private Long id;
    private final String authorizationNumber;

    public WasteCenterAuthorization(Long id, String address) {
        this.id = id;
        this.authorizationNumber = address;
    }

    public WasteCenterAuthorization(String address) {
        this.authorizationNumber = address;
    }

    public Long getId() {
        return id;
    }

    public String getAuthorizationNumber() {
        return authorizationNumber;
    }
}
