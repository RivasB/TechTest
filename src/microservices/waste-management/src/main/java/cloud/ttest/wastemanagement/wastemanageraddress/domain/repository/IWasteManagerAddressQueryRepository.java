package cloud.ttest.wastemanagement.wastemanageraddress.domain.repository;

import cloud.ttest.share.core.domain.MessagePaginatedResponse;
import cloud.ttest.wastemanagement.wastemanageraddress.domain.WasteManagerAddress;
import org.springframework.data.domain.Pageable;

public interface IWasteManagerAddressQueryRepository {

    WasteManagerAddress findById(Long id);

    MessagePaginatedResponse findAll(Pageable pageable);

    }
