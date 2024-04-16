package cloud.ttest.wastecenterauth.wastecenterauthorization.infrastructure.adapter.query;



import cloud.ttest.share.core.domain.MessagePaginatedResponse;
import cloud.ttest.wastecenterauth.wastecenterauthorization.application.WasteCenterAuthorizationResponse;
import cloud.ttest.wastecenterauth.wastecenterauthorization.domain.WasteCenterAuthorization;
import cloud.ttest.wastecenterauth.wastecenterauthorization.domain.repository.IWasteCenterAuthorizationQueryRepository;
import cloud.ttest.wastecenterauth.wastecenterauthorization.infrastructure.exception.WasteCenterAuthorizationNotFoundException;
import cloud.ttest.wastecenterauth.wastecenterauthorization.infrastructure.repository.hibernate.WasteCenterAuthorizationEntity;
import org.springframework.context.annotation.Primary;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@Primary
public class WasteCenterAuthorizationQueryRepositoryImpl implements IWasteCenterAuthorizationQueryRepository {

    private final IWasteCenterAuthorizationQueryJPARepository jpaRepository;

    public WasteCenterAuthorizationQueryRepositoryImpl(IWasteCenterAuthorizationQueryJPARepository jpaRepository) {
        this.jpaRepository = jpaRepository;
    }


    @Override
    public WasteCenterAuthorization findById(Long id) {
        WasteCenterAuthorizationEntity wasteCenterAuthorizationEntity = jpaRepository.findById(id)
                .orElseThrow(WasteCenterAuthorizationNotFoundException::new);
        return wasteCenterAuthorizationEntity.toAggregate();
    }

    @Override
    public MessagePaginatedResponse findAll(Pageable pageable) {
        Page<WasteCenterAuthorizationEntity> page = jpaRepository.findAll(pageable);
        return this.result(page);
    }

    @Override
    public List<WasteCenterAuthorization> findByList(List<Long> ids) {
        List<WasteCenterAuthorizationEntity> entityList = jpaRepository.findAllById(ids);
        return entityList.stream().map(WasteCenterAuthorizationEntity::toAggregate).toList();
    }


    private MessagePaginatedResponse result(Page<WasteCenterAuthorizationEntity> page) {
        List<WasteCenterAuthorizationResponse> response = page.stream()
                .map(WasteCenterAuthorizationResponse::new).toList();
        return new MessagePaginatedResponse(response, page);
    }

}
