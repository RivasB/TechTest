package cloud.ttest.wastemanagement.wastemanager.infrastructure.adapter.command;

import cloud.ttest.wastemanagement.wastemanager.infrastructure.repository.hibernate.WasteManagerEntity;
import org.springframework.data.jpa.repository.JpaRepository;


public interface IWasteManagerCommandJPARepository extends JpaRepository<WasteManagerEntity, Long> {

}
