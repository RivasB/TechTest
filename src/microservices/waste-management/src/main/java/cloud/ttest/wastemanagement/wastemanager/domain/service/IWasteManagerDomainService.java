package cloud.ttest.wastemanagement.wastemanager.domain.service;


import cloud.ttest.share.core.domain.MessagePaginatedResponse;
import cloud.ttest.wastemanagement.wastemanager.domain.WasteManager;
import org.springframework.data.domain.Pageable;

public interface IWasteManagerDomainService {
    void create(WasteManager wasteManager);

    void update(WasteManager wasteManager);

    void delete(WasteManager wasteManager);

    WasteManager findById(Long id);

    MessagePaginatedResponse findAll(Pageable pageable);

}
