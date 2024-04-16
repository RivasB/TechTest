package cloud.ttest.wastecenterauth.wastecenterauthorization.infrastructure.service;

import cloud.ttest.share.core.domain.MessagePaginatedResponse;
import cloud.ttest.wastecenterauth.wastecenterauthorization.domain.WasteCenterAuthorization;
import cloud.ttest.wastecenterauth.wastecenterauthorization.domain.repository.IWasteCenterAuthorizationCommandRepository;
import cloud.ttest.wastecenterauth.wastecenterauthorization.domain.repository.IWasteCenterAuthorizationQueryRepository;
import cloud.ttest.wastecenterauth.wastecenterauthorization.domain.service.IWasteCenterAuthorizationDomainService;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class WasteManagerAddressDomainServiceImpl implements IWasteCenterAuthorizationDomainService {

    private final IWasteCenterAuthorizationCommandRepository commandRepository;

    private final IWasteCenterAuthorizationQueryRepository queryRepository;

    private final Log logger = LogFactory.getLog(this.getClass());

    public WasteManagerAddressDomainServiceImpl(IWasteCenterAuthorizationCommandRepository commandRepository, IWasteCenterAuthorizationQueryRepository queryRepository) {
        this.commandRepository = commandRepository;
        this.queryRepository = queryRepository;
    }


    @Override
    public WasteCenterAuthorization create(WasteCenterAuthorization wasteCenterAuthorization) {
        WasteCenterAuthorization persisted = commandRepository.create(wasteCenterAuthorization);
        logger.info(String.format("The Waste Center Authorization with number %s was created successfully.",
                wasteCenterAuthorization.getAuthorizationNumber()));
        return persisted;
    }

    @Override
    public WasteCenterAuthorization update(WasteCenterAuthorization wasteCenterAuthorization) {
        WasteCenterAuthorization updated = commandRepository.update(wasteCenterAuthorization);
        logger.info(String.format("The Waste Center Authorization with number %s was updated successfully.",
                wasteCenterAuthorization.getAuthorizationNumber()));
        return updated;
    }

    @Override
    public void delete(WasteCenterAuthorization wasteCenterAuthorization) {
        commandRepository.delete(wasteCenterAuthorization);
        logger.info(String.format("The Waste Center Authorization with number %s was deleted successfully.",
                wasteCenterAuthorization.getAuthorizationNumber()));
    }

    @Override
    public WasteCenterAuthorization findById(Long id) {
        return queryRepository.findById(id);
    }

    @Override
    public MessagePaginatedResponse findAll(Pageable pageable) {
        return queryRepository.findAll(pageable);
    }

    @Override
    public List<WasteCenterAuthorization> getByList(List<Long> ids) {
        logger.info("A List of authorization numbers was requested by waste-management-microservice");
        return queryRepository.findByList(ids);
    }

}
