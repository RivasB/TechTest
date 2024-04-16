package cloud.ttest.wastecenterauth.wastecenterauthorization.infrastructure.adapter.query;

import cloud.ttest.wastecenterauth.wastecenterauthorization.infrastructure.repository.hibernate.WasteCenterAuthorizationEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IWasteCenterAuthorizationQueryJPARepository extends JpaRepository<WasteCenterAuthorizationEntity, Long> {

}
