package cloud.ttest.wastecenterauth.wastecenterauthorization.infrastructure.adapter.command;

import cloud.ttest.wastecenterauth.wastecenterauthorization.infrastructure.repository.hibernate.WasteCenterAuthorizationEntity;
import org.springframework.data.jpa.repository.JpaRepository;


public interface IWasteCenterAuthorizationCommandJPARepository extends JpaRepository<WasteCenterAuthorizationEntity, Long> {

}
