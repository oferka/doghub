package org.hk.doghub.data.content.generator.user.service.provider.faker;

import jakarta.validation.constraints.NotNull;
import org.apache.commons.lang3.RandomUtils;
import org.hk.doghub.data.content.generator.user.model.User;
import org.springframework.stereotype.Service;

import java.time.ZonedDateTime;

@Service
public class DateOfBirthProvider {

    public ZonedDateTime get(@NotNull User user) {
        long daysAgo = RandomUtils.nextLong(1, 30000);
        return ZonedDateTime.now().minusDays(daysAgo);
    }
}
