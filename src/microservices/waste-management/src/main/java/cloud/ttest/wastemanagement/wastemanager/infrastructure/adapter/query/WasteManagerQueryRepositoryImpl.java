package cloud.ttest.wastemanagement.wastemanager.infrastructure.adapter.query;



import cloud.ttest.share.core.domain.MessagePaginatedResponse;
import cloud.ttest.wastemanagement.wastemanager.application.WasteManagerResponse;
import cloud.ttest.wastemanagement.wastemanager.domain.WasteManager;
import cloud.ttest.wastemanagement.wastemanager.domain.repository.IWasteManagerQueryRepository;
import cloud.ttest.wastemanagement.wastemanager.infrastructure.adapter.service.http.IWasteCenterAuthHttpClient;
import cloud.ttest.wastemanagement.wastemanager.infrastructure.exception.WasteManagerNotFoundException;
import cloud.ttest.wastemanagement.wastemanager.infrastructure.repository.hibernate.WasteManagerEntity;
import org.springframework.context.annotation.Primary;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@Primary
public class WasteManagerQueryRepositoryImpl implements IWasteManagerQueryRepository {
    private final IWasteManagerQueryJPARepository jpaRepository;

    private final IWasteCenterAuthHttpClient wasteCenterAuthHttpClient;

    public WasteManagerQueryRepositoryImpl(IWasteManagerQueryJPARepository jpaRepository, IWasteCenterAuthHttpClient wasteCenterAuthHttpClient) {
        this.jpaRepository = jpaRepository;
        this.wasteCenterAuthHttpClient = wasteCenterAuthHttpClient;
    }


    @Override
    public WasteManager findById(Long id) {
        WasteManagerEntity wasteManagerEntity = jpaRepository.findById(id)
                .orElseThrow(WasteManagerNotFoundException::new);
        return wasteManagerEntity.toAggregate();
    }

    @Override
    public MessagePaginatedResponse findAll(Pageable pageable) {
        Page<WasteManagerEntity> page = jpaRepository.findAll(pageable);
        return this.result(page);
    }


    private MessagePaginatedResponse result(Page<WasteManagerEntity> page) {
        List<WasteManagerResponse> response = page.stream()
                .map(this::createWasteManagerResponse).toList();
        return new MessagePaginatedResponse(response, page);
    }

    private WasteManagerResponse createWasteManagerResponse(WasteManagerEntity wasteManagerEntity){
        List<Long> idList = wasteManagerEntity.getListOfWasteCenterAuthorizationIds();
        List<String> authNumbers = wasteCenterAuthHttpClient.authorizationNumbers(idList);
        return new WasteManagerResponse(authNumbers, wasteManagerEntity);
    }

}
