package cloud.ttest.wastemanagement.wastemanager.infrastructure.adapter.command;

import cloud.ttest.wastemanagement.wastemanager.domain.WasteManager;
import cloud.ttest.wastemanagement.wastemanager.domain.repository.IWasteManagerCommandRepository;
import cloud.ttest.wastemanagement.wastemanager.infrastructure.repository.hibernate.WasteManagerEntity;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

@Component
@Primary
public class WasteManagerCommandRepositoryImpl implements IWasteManagerCommandRepository {

    private final IWasteManagerCommandJPARepository jpaRepository;

    public WasteManagerCommandRepositoryImpl(IWasteManagerCommandJPARepository jpaRepository) {
        this.jpaRepository = jpaRepository;
    }

    @Override
    public void create(WasteManager wasteManager) {
        jpaRepository.save(new WasteManagerEntity(wasteManager));
    }

    @Override
    public void update(WasteManager wasteManager) {
        jpaRepository.save(new WasteManagerEntity(wasteManager.getId(), wasteManager));
    }

    @Override
    public void delete(WasteManager wasteManager) {
        jpaRepository.delete(new WasteManagerEntity(wasteManager.getId(), wasteManager));
    }


}
