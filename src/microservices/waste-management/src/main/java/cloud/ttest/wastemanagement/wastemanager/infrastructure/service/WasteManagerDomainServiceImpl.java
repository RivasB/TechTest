package cloud.ttest.wastemanagement.wastemanager.infrastructure.service;

import cloud.ttest.share.core.domain.MessagePaginatedResponse;
import cloud.ttest.wastemanagement.wastemanager.domain.WasteManager;
import cloud.ttest.wastemanagement.wastemanager.domain.repository.IWasteManagerCommandRepository;
import cloud.ttest.wastemanagement.wastemanager.domain.repository.IWasteManagerQueryRepository;
import cloud.ttest.wastemanagement.wastemanager.domain.service.IWasteManagerDomainService;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Component;

@Component
public class WasteManagerDomainServiceImpl implements IWasteManagerDomainService {

    private final IWasteManagerCommandRepository commandRepository;

    private final IWasteManagerQueryRepository queryRepository;

    private final Log logger = LogFactory.getLog(this.getClass());

    public WasteManagerDomainServiceImpl(IWasteManagerCommandRepository commandRepository, IWasteManagerQueryRepository queryRepository) {
        this.commandRepository = commandRepository;
        this.queryRepository = queryRepository;
    }


    @Override
    public void create(WasteManager wasteManager) {
        commandRepository.create(wasteManager);
        logger.info(String.format("The Waste Manager named %s was created successfully.", wasteManager.getName()));
    }

    @Override
    public void update(WasteManager wasteManager) {
        commandRepository.update(wasteManager);
        logger.info(String.format("The Waste Manager named %s was updated successfully.", wasteManager.getName()));
    }

    @Override
    public void delete(WasteManager wasteManager) {
        commandRepository.delete(wasteManager);
        logger.info(String.format("The Waste Manager named %s was deleted successfully.", wasteManager.getName()));
    }

    @Override
    public WasteManager findById(Long id) {
        return queryRepository.findById(id);
    }

    @Override
    public MessagePaginatedResponse findAll(Pageable pageable) {
        return queryRepository.findAll(pageable);
    }

}
