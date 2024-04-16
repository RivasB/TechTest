package cloud.ttest.wastecenterauth.wastecenterauthorization.application.query.getall;

import cloud.ttest.share.core.domain.MessagePaginatedResponse;
import cloud.ttest.share.core.domain.bus.query.IQueryHandler;
import cloud.ttest.wastecenterauth.wastecenterauthorization.domain.service.IWasteCenterAuthorizationDomainService;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Component;

@Component
public class GetAllWasteCenterAuthorizationQueryHandler implements IQueryHandler<GetAllWasteCenterAuthorizationQuery, MessagePaginatedResponse> {

    private final IWasteCenterAuthorizationDomainService wasteCenterAuthorizationDomainService;

    public GetAllWasteCenterAuthorizationQueryHandler(IWasteCenterAuthorizationDomainService wasteCenterAuthorizationDomainService) {
        this.wasteCenterAuthorizationDomainService = wasteCenterAuthorizationDomainService;
    }


    @Override
    public MessagePaginatedResponse handle(GetAllWasteCenterAuthorizationQuery query) {
        Sort sort = (query.getSortType().equals("asc"))
                ? Sort.by(query.getSortBy()).ascending() : Sort.by(query.getSortBy()).descending();
        Pageable pageable = PageRequest.of(query.getPageNo(), query.getPageSize(), sort);
        return wasteCenterAuthorizationDomainService.findAll(pageable);
    }
}
