package cloud.ttest.wastemanagement.wastemanager.domain.repository;

import cloud.ttest.share.core.domain.MessagePaginatedResponse;
import cloud.ttest.wastemanagement.wastemanager.domain.WasteManager;
import org.springframework.data.domain.Pageable;

public interface IWasteManagerQueryRepository {

    WasteManager findById(Long id);

    MessagePaginatedResponse findAll(Pageable pageable);

    }
