package cloud.ttest.wastemanagement.wastemanageraddress.infrastructure.adapter.query;



import cloud.ttest.share.core.domain.MessagePaginatedResponse;
import cloud.ttest.wastemanagement.wastemanager.application.WasteManagerResponse;
import cloud.ttest.wastemanagement.wastemanager.infrastructure.repository.hibernate.WasteManagerEntity;
import cloud.ttest.wastemanagement.wastemanageraddress.application.WasteManagerAddressResponse;
import cloud.ttest.wastemanagement.wastemanageraddress.domain.WasteManagerAddress;
import cloud.ttest.wastemanagement.wastemanageraddress.domain.repository.IWasteManagerAddressQueryRepository;
import cloud.ttest.wastemanagement.wastemanageraddress.infrastructure.exception.WasteManagerAddressNotFoundException;
import cloud.ttest.wastemanagement.wastemanageraddress.infrastructure.repository.hibernate.WasteManagerAddressEntity;
import org.springframework.context.annotation.Primary;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@Primary
public class WasteManagerAddressQueryRepositoryImpl implements IWasteManagerAddressQueryRepository {

    private final IWasteManagerAddressQueryJPARepository jpaRepository;

    public WasteManagerAddressQueryRepositoryImpl(IWasteManagerAddressQueryJPARepository jpaRepository) {
        this.jpaRepository = jpaRepository;
    }


    @Override
    public WasteManagerAddress findById(Long id) {
        WasteManagerAddressEntity wasteManagerAddressEntity = jpaRepository.findById(id)
                .orElseThrow(WasteManagerAddressNotFoundException::new);
        return wasteManagerAddressEntity.toAggregate();
    }

    @Override
    public MessagePaginatedResponse findAll(Pageable pageable) {
        Page<WasteManagerAddressEntity> page = jpaRepository.findAll(pageable);
        return this.result(page);
    }


    private MessagePaginatedResponse result(Page<WasteManagerAddressEntity> page) {
        List<WasteManagerAddressResponse> response = page.stream()
                .map(WasteManagerAddressResponse::new).toList();
        return new MessagePaginatedResponse(response, page);
    }

}
