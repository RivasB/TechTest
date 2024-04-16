package cloud.ttest.wastecenterauth.wastecenterauthorization.application.query.getbyid;

import cloud.ttest.share.core.domain.bus.query.IQueryHandler;
import cloud.ttest.wastecenterauth.wastecenterauthorization.application.WasteCenterAuthorizationResponse;
import cloud.ttest.wastecenterauth.wastecenterauthorization.domain.WasteCenterAuthorization;
import cloud.ttest.wastecenterauth.wastecenterauthorization.domain.service.IWasteCenterAuthorizationDomainService;
import org.springframework.stereotype.Component;


@Component
public class GetByIdWasteCenterAuthorizationQueryHandler implements IQueryHandler<GetByIdWasteCenterAuthorizationQuery,
        WasteCenterAuthorizationResponse> {

    private final IWasteCenterAuthorizationDomainService wasteCenterAuthorizationDomainService;

    public GetByIdWasteCenterAuthorizationQueryHandler(IWasteCenterAuthorizationDomainService wasteCenterAuthorizationDomainService) {
        this.wasteCenterAuthorizationDomainService = wasteCenterAuthorizationDomainService;
    }

    @Override
    public WasteCenterAuthorizationResponse handle(GetByIdWasteCenterAuthorizationQuery query) {
        WasteCenterAuthorization responseEntity = wasteCenterAuthorizationDomainService.findById(query.getId());
        return new WasteCenterAuthorizationResponse(responseEntity);
    }
}
