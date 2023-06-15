package org.hk.doghub.health;

import org.hk.doghub.data.service.EntityService;
import org.hk.doghub.model.AbstractEntity;
import org.springframework.boot.actuate.health.Health;
import org.springframework.boot.actuate.health.HealthIndicator;

public abstract class EntityCountHealthIndicator<T extends AbstractEntity> implements HealthIndicator {

    @Override
    public Health health() {
        Health.Builder healthBuilder;
        try {
            long count = getEntityService().count();
            healthBuilder = (count >= 0)?Health.up():Health.down();
            healthBuilder.withDetail("number_of_entries", count);
        }
        catch (Exception e) {
            healthBuilder = Health.down(e);
        }
        return healthBuilder.build();
    }

    protected abstract EntityService<T> getEntityService();
}
