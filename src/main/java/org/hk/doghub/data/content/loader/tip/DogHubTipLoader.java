package org.hk.doghub.data.content.loader.tip;

import jakarta.validation.constraints.NotNull;
import lombok.RequiredArgsConstructor;
import org.hk.doghub.data.content.loader.AbstractEntityLoader;
import org.hk.doghub.data.content.provider.EntityProvider;
import org.hk.doghub.data.content.provider.EntityProviderConfiguration;
import org.hk.doghub.data.service.EntityService;
import org.hk.doghub.model.tip.DogHubTip;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class DogHubTipLoader extends AbstractEntityLoader<DogHubTip> {

    private final EntityProvider<DogHubTip> entityProvider;

    private final EntityProviderConfiguration<DogHubTip> providerConfiguration;

    private final EntityService<DogHubTip> entityService;

    @Override
    protected @NotNull EntityProvider<DogHubTip> getEntityProvider() {
        return entityProvider;
    }

    @Override
    protected @NotNull EntityProviderConfiguration<DogHubTip> getEntityProviderConfiguration() {
        return providerConfiguration;
    }

    @Override
    protected @NotNull EntityService<DogHubTip> getEntityService() {
        return entityService;
    }

    @Override
    protected @NotNull String getEntityName() {
        return "Tip";
    }
}
