package org.hk.doghub.data.content.loader.user;

import jakarta.validation.constraints.NotNull;
import lombok.RequiredArgsConstructor;
import org.hk.doghub.data.content.loader.AbstractEntityLoader;
import org.hk.doghub.data.content.provider.EntityProvider;
import org.hk.doghub.data.content.provider.EntityProviderConfiguration;
import org.hk.doghub.data.service.EntityService;
import org.hk.doghub.model.user.DogHubUser;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class DogHubUserLoader extends AbstractEntityLoader<DogHubUser> {

    private final EntityProvider<DogHubUser> entityProvider;

    private final EntityProviderConfiguration<DogHubUser> providerConfiguration;

    private final EntityService<DogHubUser> entityService;

    @Override
    protected @NotNull EntityProvider<DogHubUser> getEntityProvider() {
        return entityProvider;
    }

    @Override
    protected @NotNull EntityProviderConfiguration<DogHubUser> getEntityProviderConfiguration() {
        return providerConfiguration;
    }

    @Override
    protected @NotNull EntityService<DogHubUser> getEntityService() {
        return entityService;
    }

    @Override
    protected @NotNull String getEntityName() {
        return "User";
    }
}
