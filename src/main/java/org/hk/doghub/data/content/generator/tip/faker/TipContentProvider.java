package org.hk.doghub.data.content.generator.tip.faker;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import net.datafaker.Faker;
import org.hk.doghub.data.content.generator.tip.Tip;
import org.springframework.stereotype.Service;

import static org.hk.doghub.data.content.generator.tip.Tip.CONTENT_MAX_LENGTH;

@Service
public class TipContentProvider {

    public @NotNull @NotBlank @Size(max = CONTENT_MAX_LENGTH) String get(@NotNull Tip tip) {
        return new Faker().book().genre();
    }
}
