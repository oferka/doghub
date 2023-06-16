package org.hk.doghub.health.dog;

import lombok.RequiredArgsConstructor;
import org.hk.doghub.data.service.EntityService;
import org.hk.doghub.health.EntityCountHealthIndicator;
import org.hk.doghub.model.dog.DogHubDog;
import org.springframework.boot.actuate.autoconfigure.health.ConditionalOnEnabledHealthIndicator;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
@ConditionalOnEnabledHealthIndicator("dogHubDogCountHealthIndicator")
public class DogHubDogCountHealthIndicator extends EntityCountHealthIndicator<DogHubDog> {

    private final EntityService<DogHubDog> entityService;

    @Override
    protected EntityService<DogHubDog> getEntityService() {
        return entityService;
    }
}
