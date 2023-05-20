package org.hk.doghub.health.user;

import lombok.RequiredArgsConstructor;
import org.hk.doghub.data.service.user.DogHubUserService;
import org.springframework.boot.actuate.autoconfigure.health.ConditionalOnEnabledHealthIndicator;
import org.springframework.boot.actuate.health.Health;
import org.springframework.boot.actuate.health.HealthIndicator;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
@ConditionalOnEnabledHealthIndicator("dogHubUserCountHealthIndicator")
public class DogHubUserCountHealthIndicator implements HealthIndicator {

    private final DogHubUserService dogHubUserService;

    @Override
    public Health health() {
        Health.Builder healthBuilder;
        try {
            long count = dogHubUserService.count();
            healthBuilder = (count >= 0)?Health.up():Health.down();
            healthBuilder.withDetail("number_of_entries", count);
        }
        catch (Exception e) {
            healthBuilder = Health.down(e);
        }
        return healthBuilder.build();
    }
}
