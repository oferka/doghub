package org.hk.doghub.data.content.loader.dog;

import jakarta.validation.constraints.NotNull;
import lombok.RequiredArgsConstructor;
import org.hk.doghub.data.content.loader.AbstractEntityLoader;
import org.hk.doghub.data.content.provider.EntityProvider;
import org.hk.doghub.data.content.provider.EntityProviderConfiguration;
import org.hk.doghub.data.service.EntityService;
import org.hk.doghub.model.dog.DogHubDog;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class DogHubDogLoader extends AbstractEntityLoader<DogHubDog> {

    private final EntityProvider<DogHubDog> entityProvider;

    private final EntityProviderConfiguration<DogHubDog> providerConfiguration;

    private final EntityService<DogHubDog> entityService;

    @Override
    protected @NotNull EntityProvider<DogHubDog> getEntityProvider() {
        return entityProvider;
    }

    @Override
    protected @NotNull EntityProviderConfiguration<DogHubDog> getEntityProviderConfiguration() {
        return providerConfiguration;
    }

    @Override
    protected @NotNull EntityService<DogHubDog> getEntityService() {
        return entityService;
    }

    @Override
    protected @NotNull String getEntityName() {
        return "Dog";
    }
}
