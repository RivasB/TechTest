package cloud.ttest.wastecenterauth.wastecenterauthorization.domain.service;


import cloud.ttest.share.core.domain.MessagePaginatedResponse;
import cloud.ttest.wastecenterauth.wastecenterauthorization.domain.WasteCenterAuthorization;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface IWasteCenterAuthorizationDomainService {
    WasteCenterAuthorization create(WasteCenterAuthorization wasteCenterAuthorization);

    WasteCenterAuthorization update(WasteCenterAuthorization wasteCenterAuthorization);

    void delete(WasteCenterAuthorization wasteCenterAuthorization);

    WasteCenterAuthorization findById(Long id);

    MessagePaginatedResponse findAll(Pageable pageable);

    List<WasteCenterAuthorization> getByList(List<Long> ids);

}
