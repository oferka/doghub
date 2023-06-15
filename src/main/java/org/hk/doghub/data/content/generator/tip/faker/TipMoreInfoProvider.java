package org.hk.doghub.data.content.generator.tip.faker;

import jakarta.validation.constraints.NotNull;
import net.datafaker.Faker;
import org.hibernate.validator.constraints.URL;
import org.hk.doghub.data.content.generator.tip.Tip;
import org.springframework.stereotype.Service;

@Service
public class TipMoreInfoProvider {

    public @URL String get(@NotNull Tip tip) {
        return new Faker().internet().url();
    }
}
