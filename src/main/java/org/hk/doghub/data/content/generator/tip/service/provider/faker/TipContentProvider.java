package org.hk.doghub.data.content.generator.tip.service.provider.faker;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import net.datafaker.Faker;
import org.hk.doghub.data.content.generator.tip.model.Tip;
import org.springframework.stereotype.Service;

@Service
public class TipContentProvider {

    public @NotNull @Size(min = 2, max = 1024) @NotBlank String get(@NotNull Tip tip) {
        return new Faker().book().genre();
    }
}
