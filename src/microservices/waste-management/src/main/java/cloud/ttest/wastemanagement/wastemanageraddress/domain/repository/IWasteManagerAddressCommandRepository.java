package cloud.ttest.wastemanagement.wastemanageraddress.domain.repository;

import cloud.ttest.wastemanagement.wastemanageraddress.domain.WasteManagerAddress;

public interface IWasteManagerAddressCommandRepository {

    WasteManagerAddress create(WasteManagerAddress wasteManagerAddress);

    WasteManagerAddress update(WasteManagerAddress wasteManagerAddress);

    void delete(WasteManagerAddress wasteManagerAddress);
}
