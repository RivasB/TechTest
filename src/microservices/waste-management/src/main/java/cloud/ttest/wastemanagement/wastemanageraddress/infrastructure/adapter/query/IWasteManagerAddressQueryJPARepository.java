package cloud.ttest.wastemanagement.wastemanageraddress.infrastructure.adapter.query;

import cloud.ttest.wastemanagement.wastemanageraddress.infrastructure.repository.hibernate.WasteManagerAddressEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IWasteManagerAddressQueryJPARepository extends JpaRepository<WasteManagerAddressEntity, Long> {

}
