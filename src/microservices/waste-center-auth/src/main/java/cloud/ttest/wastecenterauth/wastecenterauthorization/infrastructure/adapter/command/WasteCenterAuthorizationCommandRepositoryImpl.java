package cloud.ttest.wastecenterauth.wastecenterauthorization.infrastructure.adapter.command;

import cloud.ttest.wastecenterauth.wastecenterauthorization.infrastructure.repository.hibernate.WasteCenterAuthorizationEntity;
import cloud.ttest.wastecenterauth.wastecenterauthorization.domain.WasteCenterAuthorization;
import cloud.ttest.wastecenterauth.wastecenterauthorization.domain.repository.IWasteCenterAuthorizationCommandRepository;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

@Component
@Primary
public class WasteCenterAuthorizationCommandRepositoryImpl implements IWasteCenterAuthorizationCommandRepository {

    private final IWasteCenterAuthorizationCommandJPARepository jpaRepository;

    public WasteCenterAuthorizationCommandRepositoryImpl(IWasteCenterAuthorizationCommandJPARepository jpaRepository) {
        this.jpaRepository = jpaRepository;
    }

    @Override
    public WasteCenterAuthorization create(WasteCenterAuthorization wasteCenterAuthorization) {
        WasteCenterAuthorizationEntity persisted = jpaRepository.save(new WasteCenterAuthorizationEntity(wasteCenterAuthorization));
        return persisted.toAggregate();
    }

    @Override
    public WasteCenterAuthorization update(WasteCenterAuthorization wasteCenterAuthorization) {
        WasteCenterAuthorizationEntity updated = jpaRepository.save(new WasteCenterAuthorizationEntity(wasteCenterAuthorization.getId(),
                wasteCenterAuthorization));
        return updated.toAggregate();
    }

    @Override
    public void delete(WasteCenterAuthorization wasteCenterAuthorization) {
        jpaRepository.delete(new WasteCenterAuthorizationEntity(wasteCenterAuthorization.getId(), wasteCenterAuthorization));
    }


}
