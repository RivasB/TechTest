package cloud.ttest.wastemanagement.wastemanageraddress.infrastructure.adapter.command;

import cloud.ttest.wastemanagement.wastemanageraddress.domain.WasteManagerAddress;
import cloud.ttest.wastemanagement.wastemanageraddress.domain.repository.IWasteManagerAddressCommandRepository;
import cloud.ttest.wastemanagement.wastemanageraddress.infrastructure.repository.hibernate.WasteManagerAddressEntity;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

@Component
@Primary
public class WasteManagerAddressCommandRepositoryImpl implements IWasteManagerAddressCommandRepository {

    private final IWasteManagerAddressCommandJPARepository jpaRepository;

    public WasteManagerAddressCommandRepositoryImpl(IWasteManagerAddressCommandJPARepository jpaRepository) {
        this.jpaRepository = jpaRepository;
    }

    @Override
    public WasteManagerAddress create(WasteManagerAddress wasteManagerAddress) {
        WasteManagerAddressEntity persisted = jpaRepository.save(new WasteManagerAddressEntity(wasteManagerAddress));
        return persisted.toAggregate();
    }

    @Override
    public WasteManagerAddress update(WasteManagerAddress wasteManagerAddress) {
        WasteManagerAddressEntity updated = jpaRepository.save(new WasteManagerAddressEntity(wasteManagerAddress.getId(),
                wasteManagerAddress));
        return updated.toAggregate();
    }

    @Override
    public void delete(WasteManagerAddress wasteManagerAddress) {
        jpaRepository.delete(new WasteManagerAddressEntity(wasteManagerAddress.getId(), wasteManagerAddress));
    }


}
