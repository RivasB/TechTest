package cloud.ttest.wastemanagement.wastemanageraddress.application.query.getbyid;

import cloud.ttest.share.core.domain.bus.query.IQueryHandler;
import cloud.ttest.wastemanagement.wastemanageraddress.application.WasteManagerAddressResponse;
import cloud.ttest.wastemanagement.wastemanageraddress.domain.WasteManagerAddress;
import cloud.ttest.wastemanagement.wastemanageraddress.domain.service.IWasteManagerAddressDomainService;
import org.springframework.stereotype.Component;


@Component
public class GetByIdWasteManagerAddressQueryHandler implements IQueryHandler<GetByIdWasteManagerAddressQuery,
        WasteManagerAddressResponse> {

    private final IWasteManagerAddressDomainService wasteManagerAddressDomainService;

    public GetByIdWasteManagerAddressQueryHandler(IWasteManagerAddressDomainService wasteManagerAddressDomainService) {
        this.wasteManagerAddressDomainService = wasteManagerAddressDomainService;
    }

    @Override
    public WasteManagerAddressResponse handle(GetByIdWasteManagerAddressQuery query) {
        WasteManagerAddress responseEntity = wasteManagerAddressDomainService.findById(query.getId());
        return new WasteManagerAddressResponse(responseEntity);
    }
}
