package cloud.ttest.wastecenterauth.wastecenterauthorization.domain.repository;

import cloud.ttest.wastecenterauth.wastecenterauthorization.domain.WasteCenterAuthorization;

public interface IWasteCenterAuthorizationCommandRepository {

    WasteCenterAuthorization create(WasteCenterAuthorization wasteCenterAuthorization);

    WasteCenterAuthorization update(WasteCenterAuthorization wasteCenterAuthorization);

    void delete(WasteCenterAuthorization wasteCenterAuthorization);
}
