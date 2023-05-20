package org.hk.doghub.data.content.generator.user.service.provider.faker;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import net.datafaker.Faker;
import org.hk.doghub.data.content.generator.user.model.Address;
import org.springframework.stereotype.Service;

@Service
public class StreetNameProvider {

    public @NotNull @Size(min = 2, max = 64) @NotBlank String get(@NotNull Address address) {
        return new Faker().address().streetName();
    }
}
