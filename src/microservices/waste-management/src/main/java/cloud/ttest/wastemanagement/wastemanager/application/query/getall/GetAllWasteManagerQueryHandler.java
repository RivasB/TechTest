package cloud.ttest.wastemanagement.wastemanager.application.query.getall;

import cloud.ttest.share.core.domain.MessagePaginatedResponse;
import cloud.ttest.share.core.domain.bus.query.IQueryHandler;
import cloud.ttest.wastemanagement.wastemanager.domain.service.IWasteManagerDomainService;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Component;

@Component
public class GetAllWasteManagerQueryHandler implements IQueryHandler<GetAllWasteManagerQuery, MessagePaginatedResponse> {

    private final IWasteManagerDomainService wasteManagerDomainService;

    public GetAllWasteManagerQueryHandler(IWasteManagerDomainService wasteManagerDomainService) {
        this.wasteManagerDomainService = wasteManagerDomainService;
    }

    @Override
    public MessagePaginatedResponse handle(GetAllWasteManagerQuery query) {
        Sort sort = (query.getSortType().equals("asc"))
                ? Sort.by(query.getSortBy()).ascending() : Sort.by(query.getSortBy()).descending();
        Pageable pageable = PageRequest.of(query.getPageNo(), query.getPageSize(), sort);
        return wasteManagerDomainService.findAll(pageable);
    }
}
