package cloud.ttest.wastemanagement.wastemanager.infrastructure.repository.hibernate;
import cloud.ttest.wastemanagement.shared.infrastructure.repository.hibernate.AuditableBase;
import cloud.ttest.wastemanagement.wastemanager.domain.WasteManager;
import cloud.ttest.wastemanagement.wastemanageraddress.infrastructure.repository.hibernate.WasteManagerAddressEntity;
import jakarta.persistence.*;
import org.hibernate.annotations.GenericGenerator;

import java.util.List;

@Entity
@Table(name = "waste_manager")
public class WasteManagerEntity extends AuditableBase {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "native")
    @GenericGenerator(name = "native", strategy = "native")
    private Long id;

    @Column(nullable = false, length = 250)
    private String name;

    @Column(nullable = false, unique = true, length = 15)
    private String nif;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "address_id", referencedColumnName = "id")
    private WasteManagerAddressEntity wasteManagerAddress;

    @ElementCollection(fetch = FetchType.EAGER)
    @CollectionTable(name = "waste_center_authorizations", joinColumns = @JoinColumn(name = "waste_manager_id"))
    @Column(name = "authorization_id")
    private List<Long> listOfWasteCenterAuthorizationIds;

    @Column(name = "is_enabled")
    private Boolean isEnabled;

    public WasteManagerEntity(WasteManager wasteManager){
        this.name = wasteManager.getName();
        this.nif = wasteManager.getNif();
        this.wasteManagerAddress = new WasteManagerAddressEntity(wasteManager.getWasteManagerAddress());
        this.listOfWasteCenterAuthorizationIds = wasteManager.getListOfWasteCenterAuthorizationIds();
        this.isEnabled = wasteManager.getEnabled();
    }

    public WasteManagerEntity(Long id, WasteManager wasteManager){
        this.id = id;
        this.name = wasteManager.getName();
        this.nif = wasteManager.getNif();
        this.wasteManagerAddress = new WasteManagerAddressEntity(wasteManager.getWasteManagerAddress());
        this.listOfWasteCenterAuthorizationIds = wasteManager.getListOfWasteCenterAuthorizationIds();
        this.isEnabled = wasteManager.getEnabled();
    }



    public WasteManagerEntity() {

    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getNif() {
        return nif;
    }

    public WasteManagerAddressEntity getWasteManagerAddress() {
        return wasteManagerAddress;
    }

    public List<Long> getListOfWasteCenterAuthorizationIds() {
        return listOfWasteCenterAuthorizationIds;
    }

    public Boolean getEnabled() {
        return isEnabled;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setNif(String nif) {
        this.nif = nif;
    }

    public void setWasteManagerAddress(WasteManagerAddressEntity wasteManagerAddress) {
        this.wasteManagerAddress = wasteManagerAddress;
    }

    public void setListOfWasteCenterAuthorizationIds(List<Long> listOfWasteCenterAuthorizationIds) {
        this.listOfWasteCenterAuthorizationIds = listOfWasteCenterAuthorizationIds;
    }

    public void setEnabled(Boolean enabled) {
        isEnabled = enabled;
    }

    public WasteManager toAggregate() {
        return new WasteManager(
                this.id,
                this.name,
                this.nif,
                this.wasteManagerAddress.toAggregate(),
                this.listOfWasteCenterAuthorizationIds,
                this.isEnabled
        );
    }
}
