package cloud.ttest.wastemanagement.wastemanageraddress.application.query.getall;

import cloud.ttest.share.core.domain.MessagePaginatedResponse;
import cloud.ttest.share.core.domain.bus.query.IQueryHandler;
import cloud.ttest.wastemanagement.wastemanageraddress.domain.service.IWasteManagerAddressDomainService;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Component;

@Component
public class GetAllWasteManagerAddressQueryHandler implements IQueryHandler<GetAllWasteManagerAddressQuery, MessagePaginatedResponse> {

    private final IWasteManagerAddressDomainService wasteManagerAddressDomainService;

    public GetAllWasteManagerAddressQueryHandler(IWasteManagerAddressDomainService wasteManagerAddressDomainService) {
        this.wasteManagerAddressDomainService = wasteManagerAddressDomainService;
    }


    @Override
    public MessagePaginatedResponse handle(GetAllWasteManagerAddressQuery query) {
        Sort sort = (query.getSortType().equals("asc"))
                ? Sort.by(query.getSortBy()).ascending() : Sort.by(query.getSortBy()).descending();
        Pageable pageable = PageRequest.of(query.getPageNo(), query.getPageSize(), sort);
        return wasteManagerAddressDomainService.findAll(pageable);
    }
}
