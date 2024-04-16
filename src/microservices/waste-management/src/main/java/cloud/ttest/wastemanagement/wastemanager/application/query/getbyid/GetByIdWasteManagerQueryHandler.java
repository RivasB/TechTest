package cloud.ttest.wastemanagement.wastemanager.application.query.getbyid;

import cloud.ttest.share.core.domain.bus.query.IQueryHandler;
import cloud.ttest.wastemanagement.wastemanager.application.WasteManagerResponse;
import cloud.ttest.wastemanagement.wastemanager.domain.WasteManager;
import cloud.ttest.wastemanagement.wastemanager.domain.service.IWasteManagerDomainService;
import cloud.ttest.wastemanagement.wastemanager.infrastructure.adapter.service.http.IWasteCenterAuthHttpClient;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Component
public class GetByIdWasteManagerQueryHandler implements IQueryHandler<GetByIdWasteManagerQuery, WasteManagerResponse> {

    private final IWasteManagerDomainService wasteManagerDomainService;

    private final IWasteCenterAuthHttpClient wasteCenterAuthHttpClient;

    public GetByIdWasteManagerQueryHandler(IWasteManagerDomainService wasteManagerDomainService, IWasteCenterAuthHttpClient wasteCenterAuthHttpClient) {
        this.wasteManagerDomainService = wasteManagerDomainService;
        this.wasteCenterAuthHttpClient = wasteCenterAuthHttpClient;
    }

    @Override
    @Transactional
    public WasteManagerResponse handle(GetByIdWasteManagerQuery query) {
        WasteManager responseEntity = wasteManagerDomainService.findById(query.getId());
        List<String> authList =
                wasteCenterAuthHttpClient.authorizationNumbers(responseEntity.getListOfWasteCenterAuthorizationIds());
        return new WasteManagerResponse(authList,responseEntity);
    }
}
