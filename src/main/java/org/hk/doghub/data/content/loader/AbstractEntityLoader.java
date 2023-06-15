package org.hk.doghub.data.content.loader;

import jakarta.validation.constraints.NotNull;
import lombok.extern.slf4j.Slf4j;
import org.hk.doghub.data.content.provider.EntityProvider;
import org.hk.doghub.data.content.provider.EntityProviderConfiguration;
import org.hk.doghub.data.service.EntityService;
import org.hk.doghub.model.AbstractEntity;

import java.util.List;

@Slf4j
public abstract class AbstractEntityLoader<T extends AbstractEntity> implements EntityLoader {

    public long load() {
        List<T> content = getEntityProvider().get(getEntityProviderConfiguration().getNumberOfItems());
        long savedEntitiesCounter = 0;
        for(T contentItem : content) {
            try {
                getEntityService().save(contentItem);
                savedEntitiesCounter++;
            }
            catch (Exception e) {
                log.warn("Failed to save entity");
            }
        }
        log.info("{} {} entities loaded", savedEntitiesCounter, getEntityName());
        return savedEntitiesCounter;
    }

    protected abstract @NotNull EntityProvider<T> getEntityProvider();
    protected abstract @NotNull EntityProviderConfiguration<T> getEntityProviderConfiguration();
    protected abstract @NotNull EntityService<T> getEntityService();

    protected abstract @NotNull String getEntityName();
}
