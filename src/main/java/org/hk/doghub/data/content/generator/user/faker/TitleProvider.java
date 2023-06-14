package org.hk.doghub.data.content.generator.user.faker;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import org.hk.doghub.data.content.generator.user.User;
import org.springframework.stereotype.Service;

import java.util.List;

import static java.util.Arrays.asList;
import static org.apache.commons.lang3.RandomUtils.nextInt;

@Service
public class TitleProvider {

    public @NotNull @Size(min = 2, max = 64) @NotBlank String get(@NotNull User user) {
        List<String> titleValues = asList("Mr.", "Mrs.", "Ms.", "Miss", "Dr.", "Rev.", "Prof.", "Hon.", "Capt.", "Col.", "Lt.", "Sen.", "Rep.", "Gov.", "Pres.", "Sir", "Dame", "Lady", "Lord", "Knight", "Prince", "Princess");
        return titleValues.get(nextInt(0, titleValues.size()));
    }
}
