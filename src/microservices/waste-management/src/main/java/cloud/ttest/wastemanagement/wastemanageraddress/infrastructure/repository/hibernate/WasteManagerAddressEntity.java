package cloud.ttest.wastemanagement.wastemanageraddress.infrastructure.repository.hibernate;

import cloud.ttest.wastemanagement.shared.infrastructure.repository.hibernate.AuditableBase;
import cloud.ttest.wastemanagement.wastemanager.infrastructure.repository.hibernate.WasteManagerEntity;
import cloud.ttest.wastemanagement.wastemanageraddress.domain.WasteManagerAddress;
import jakarta.persistence.*;
import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name = "waste_manager_address")
public class WasteManagerAddressEntity extends AuditableBase {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "native")
    @GenericGenerator(name = "native", strategy = "native")
    private Long id;

    @Column(nullable = false, length = 250)
    private String address;

    @OneToOne(mappedBy = "wasteManagerAddress")
    private WasteManagerEntity wasteManager;

    @Column(name = "is_enabled")
    private Boolean isEnabled;


    public WasteManagerAddressEntity(WasteManagerAddress wasteManagerAddress){
        this.id = wasteManagerAddress.getId();
        this.address = wasteManagerAddress.getAddress();
        this.isEnabled = wasteManagerAddress.getEnabled();
    }

    public WasteManagerAddressEntity(Long id, WasteManagerAddress wasteManagerAddress){
        this.id = id;
        this.address = wasteManagerAddress.getAddress();
        this.isEnabled = wasteManagerAddress.getEnabled();
    }

    public WasteManagerAddressEntity() {

    }

    public Long getId() {
        return id;
    }

    public String getAddress() {
        return address;
    }

    public Boolean getEnabled() {
        return isEnabled;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void setEnabled(Boolean enabled) {
        isEnabled = enabled;
    }

    public WasteManagerAddress toAggregate(){
        return new WasteManagerAddress(
                this.id,
                this.address,
                this.isEnabled
        );
    }

}
