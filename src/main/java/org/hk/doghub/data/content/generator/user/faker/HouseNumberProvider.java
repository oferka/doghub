package org.hk.doghub.data.content.generator.user.faker;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import org.apache.commons.lang3.RandomUtils;
import org.hk.doghub.data.content.generator.user.Address;
import org.springframework.stereotype.Service;

@Service
public class HouseNumberProvider {

    public @Positive int get(@NotNull Address address) {
        return RandomUtils.nextInt(1, 3000);
    }
}
