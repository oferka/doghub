package org.hk.doghub.health.tip;

import lombok.RequiredArgsConstructor;
import org.hk.doghub.data.service.tip.DogHubTipService;
import org.springframework.boot.actuate.autoconfigure.health.ConditionalOnEnabledHealthIndicator;
import org.springframework.boot.actuate.health.Health;
import org.springframework.boot.actuate.health.HealthIndicator;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
@ConditionalOnEnabledHealthIndicator("dogHubTipCountHealthIndicator")
public class DogHubTipCountHealthIndicator implements HealthIndicator {

    private final DogHubTipService dogHubTipService;

    @Override
    public Health health() {
        Health.Builder healthBuilder;
        try {
            long count = dogHubTipService.count();
            healthBuilder = (count >= 0)?Health.up():Health.down();
            healthBuilder.withDetail("number_of_entries", count);
        }
        catch (Exception e) {
            healthBuilder = Health.down(e);
        }
        return healthBuilder.build();
    }
}
