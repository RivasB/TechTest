package cloud.ttest.wastemanagement.wastemanageraddress.domain.service;


import cloud.ttest.share.core.domain.MessagePaginatedResponse;
import cloud.ttest.wastemanagement.wastemanageraddress.domain.WasteManagerAddress;
import org.springframework.data.domain.Pageable;

public interface IWasteManagerAddressDomainService {
    WasteManagerAddress create(WasteManagerAddress wasteManagerAddress);

    WasteManagerAddress update(WasteManagerAddress wasteManagerAddress);

    void delete(WasteManagerAddress wasteManagerAddress);

    WasteManagerAddress findById(Long id);

    MessagePaginatedResponse findAll(Pageable pageable);

}
