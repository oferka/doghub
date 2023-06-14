package org.hk.doghub.data.content.generator.tip.faker;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import net.datafaker.Faker;
import org.hk.doghub.data.content.generator.tip.Tip;
import org.springframework.stereotype.Service;

@Service
public class TipTitleProvider {

    public @NotNull @Size(min = 2, max = 64) @NotBlank String get(@NotNull Tip tip) {
        Faker faker = new Faker();
        return faker.book().title() + " - " + faker.expression("#{regexify '[a-z]{3,5}'}");
    }
}
