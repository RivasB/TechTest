package cloud.ttest.wastecenterauth.wastecenterauthorization.domain.repository;

import cloud.ttest.share.core.domain.MessagePaginatedResponse;
import cloud.ttest.wastecenterauth.wastecenterauthorization.domain.WasteCenterAuthorization;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface IWasteCenterAuthorizationQueryRepository {

    WasteCenterAuthorization findById(Long id);

    MessagePaginatedResponse findAll(Pageable pageable);

    List<WasteCenterAuthorization> findByList(List<Long> ids);
}
