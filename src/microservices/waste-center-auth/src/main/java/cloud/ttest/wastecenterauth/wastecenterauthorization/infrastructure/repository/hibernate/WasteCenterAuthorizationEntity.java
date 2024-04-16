package cloud.ttest.wastecenterauth.wastecenterauthorization.infrastructure.repository.hibernate;

import cloud.ttest.wastecenterauth.shared.infrastructure.repository.hibernate.AuditableBase;
import cloud.ttest.wastecenterauth.wastecenterauthorization.domain.WasteCenterAuthorization;
import jakarta.persistence.*;
import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name = "waste_center_authorization")
public class WasteCenterAuthorizationEntity extends AuditableBase {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "native")
    @GenericGenerator(name = "native", strategy = "native")
    private Long id;

    @Column(nullable = false, length = 250)
    private String authorizationNumber;


    public WasteCenterAuthorizationEntity(WasteCenterAuthorization wasteCenterAuthorization){
        this.id = wasteCenterAuthorization.getId();
        this.authorizationNumber = wasteCenterAuthorization.getAuthorizationNumber();
    }

    public WasteCenterAuthorizationEntity(Long id, WasteCenterAuthorization wasteCenterAuthorization){
        this.id = id;
        this.authorizationNumber = wasteCenterAuthorization.getAuthorizationNumber();
    }

    public WasteCenterAuthorizationEntity() {

    }

    public Long getId() {
        return id;
    }

    public String getAuthorizationNumber() {
        return authorizationNumber;
    }

    public WasteCenterAuthorization toAggregate(){
        return new WasteCenterAuthorization(
                this.id,
                this.authorizationNumber
        );
    }

}
