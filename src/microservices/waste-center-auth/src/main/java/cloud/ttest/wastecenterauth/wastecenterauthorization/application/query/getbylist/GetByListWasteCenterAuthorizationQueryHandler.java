package cloud.ttest.wastecenterauth.wastecenterauthorization.application.query.getbylist;

import cloud.ttest.share.core.domain.bus.query.IQueryHandler;
import cloud.ttest.wastecenterauth.wastecenterauthorization.application.WasteCenterAuthorizationResponse;
import cloud.ttest.wastecenterauth.wastecenterauthorization.application.query.getbyid.GetByIdWasteCenterAuthorizationQuery;
import cloud.ttest.wastecenterauth.wastecenterauthorization.domain.WasteCenterAuthorization;
import cloud.ttest.wastecenterauth.wastecenterauthorization.domain.service.IWasteCenterAuthorizationDomainService;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;


@Component
public class GetByListWasteCenterAuthorizationQueryHandler implements IQueryHandler<GetByListWasteCenterAuthorizationQuery,
        GetByListWasteCenterAuthorizationResponse> {

    private final IWasteCenterAuthorizationDomainService wasteCenterAuthorizationDomainService;

    public GetByListWasteCenterAuthorizationQueryHandler(IWasteCenterAuthorizationDomainService wasteCenterAuthorizationDomainService) {
        this.wasteCenterAuthorizationDomainService = wasteCenterAuthorizationDomainService;
    }


    @Override
    public GetByListWasteCenterAuthorizationResponse handle(GetByListWasteCenterAuthorizationQuery query) {
        List<WasteCenterAuthorization> authorizations = wasteCenterAuthorizationDomainService.getByList(query.getIds());
        List<String> numbers = new ArrayList<>();
        authorizations.forEach(item -> {
            numbers.add(item.getAuthorizationNumber());
        });
        return new GetByListWasteCenterAuthorizationResponse(numbers);
    }
}
