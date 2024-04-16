package cloud.ttest.wastemanagement.wastemanager.domain.repository;

import cloud.ttest.wastemanagement.wastemanager.domain.WasteManager;

public interface IWasteManagerCommandRepository {

    void create(WasteManager wasteManager);

    void update(WasteManager wasteManager);

    void delete(WasteManager wasteManager);
}
