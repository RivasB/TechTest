package cloud.ttest.wastemanagement.wastemanager.infrastructure.adapter.query;

import cloud.ttest.wastemanagement.wastemanager.infrastructure.repository.hibernate.WasteManagerEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IWasteManagerQueryJPARepository extends JpaRepository<WasteManagerEntity, Long> {

}
