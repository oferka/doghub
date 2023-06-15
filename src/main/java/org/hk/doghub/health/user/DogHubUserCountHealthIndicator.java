package org.hk.doghub.health.user;

import lombok.RequiredArgsConstructor;
import org.hk.doghub.data.service.EntityService;
import org.hk.doghub.health.EntityCountHealthIndicator;
import org.hk.doghub.model.user.DogHubUser;
import org.springframework.boot.actuate.autoconfigure.health.ConditionalOnEnabledHealthIndicator;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
@ConditionalOnEnabledHealthIndicator("dogHubUserCountHealthIndicator")
public class DogHubUserCountHealthIndicator extends EntityCountHealthIndicator<DogHubUser> {

    private final EntityService<DogHubUser> entityService;

    @Override
    protected EntityService<DogHubUser> getEntityService() {
        return entityService;
    }
}
