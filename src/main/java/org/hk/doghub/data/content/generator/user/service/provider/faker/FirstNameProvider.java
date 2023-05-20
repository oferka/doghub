package org.hk.doghub.data.content.generator.user.service.provider.faker;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import net.datafaker.Faker;
import org.hk.doghub.data.content.generator.user.model.User;
import org.springframework.stereotype.Service;

@Service
public class FirstNameProvider {

    public @NotNull @Size(min = 2, max = 64) @NotBlank String get(@NotNull User user) {
        return new Faker().name().firstName();
    }
}
