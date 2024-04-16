package cloud.ttest.wastemanagement.wastemanageraddress.infrastructure.adapter.command;

import cloud.ttest.wastemanagement.wastemanageraddress.infrastructure.repository.hibernate.WasteManagerAddressEntity;
import org.springframework.data.jpa.repository.JpaRepository;


public interface IWasteManagerAddressCommandJPARepository extends JpaRepository<WasteManagerAddressEntity, Long> {

}
