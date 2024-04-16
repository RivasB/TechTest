package cloud.ttest.wastemanagement.wastemanageraddress.infrastructure.service;

import cloud.ttest.share.core.domain.MessagePaginatedResponse;
import cloud.ttest.wastemanagement.wastemanageraddress.domain.WasteManagerAddress;
import cloud.ttest.wastemanagement.wastemanageraddress.domain.repository.IWasteManagerAddressCommandRepository;
import cloud.ttest.wastemanagement.wastemanageraddress.domain.repository.IWasteManagerAddressQueryRepository;
import cloud.ttest.wastemanagement.wastemanageraddress.domain.service.IWasteManagerAddressDomainService;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Component;

@Component
public class WasteManagerAddressDomainServiceImpl implements IWasteManagerAddressDomainService {

    private final IWasteManagerAddressCommandRepository commandRepository;

    private final IWasteManagerAddressQueryRepository queryRepository;

    private final Log logger = LogFactory.getLog(this.getClass());

    public WasteManagerAddressDomainServiceImpl(IWasteManagerAddressCommandRepository commandRepository, IWasteManagerAddressQueryRepository queryRepository) {
        this.commandRepository = commandRepository;
        this.queryRepository = queryRepository;
    }


    @Override
    public WasteManagerAddress create(WasteManagerAddress wasteManagerAddress) {
        WasteManagerAddress persisted = commandRepository.create(wasteManagerAddress);
        logger.info(String.format("The Waste Manager Address with id %s was created successfully.",
                wasteManagerAddress.getId()));
        return persisted;
    }

    @Override
    public WasteManagerAddress update(WasteManagerAddress wasteManagerAddress) {
        WasteManagerAddress updated = commandRepository.update(wasteManagerAddress);
        logger.info(String.format("The Waste Manager Address with id %s was updated successfully.",
                wasteManagerAddress.getId()));
        return updated;
    }

    @Override
    public void delete(WasteManagerAddress wasteManagerAddress) {
        commandRepository.delete(wasteManagerAddress);
        logger.info(String.format("The Waste Manager Address with id %s was deleted successfully.",
                wasteManagerAddress.getId()));
    }

    @Override
    public WasteManagerAddress findById(Long id) {
        return queryRepository.findById(id);
    }

    @Override
    public MessagePaginatedResponse findAll(Pageable pageable) {
        return queryRepository.findAll(pageable);
    }

}
