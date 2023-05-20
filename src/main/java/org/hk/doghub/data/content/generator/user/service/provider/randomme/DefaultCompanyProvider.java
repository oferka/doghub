package org.hk.doghub.data.content.generator.user.service.provider.randomme;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import net.datafaker.Faker;
import org.hk.doghub.data.content.generator.user.service.provider.randomme.response.Result;
import org.springframework.stereotype.Service;

@Service
public class DefaultCompanyProvider implements CompanyProvider {

    public @NotNull @NotBlank @Size(min = 2, max = 64) String get(Result result) {
        return new Faker().company().name();
    }
}
