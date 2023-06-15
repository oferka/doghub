package org.hk.doghub.health.tip;

import lombok.RequiredArgsConstructor;
import org.hk.doghub.data.service.EntityService;
import org.hk.doghub.health.EntityCountHealthIndicator;
import org.hk.doghub.model.tip.DogHubTip;
import org.springframework.boot.actuate.autoconfigure.health.ConditionalOnEnabledHealthIndicator;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
@ConditionalOnEnabledHealthIndicator("dogHubTipCountHealthIndicator")
public class DogHubTipCountHealthIndicator extends EntityCountHealthIndicator<DogHubTip> {

    private final EntityService<DogHubTip> entityService;

    @Override
    protected EntityService<DogHubTip> getEntityService() {
        return entityService;
    }
}
