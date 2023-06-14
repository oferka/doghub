package org.hk.doghub.data.content.provider.tip;

import jakarta.validation.constraints.NotNull;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.hk.doghub.data.content.generator.GeneratorService;
import org.hk.doghub.data.content.generator.tip.Tip;
import org.hk.doghub.data.content.provider.Converter;
import org.hk.doghub.data.content.provider.EntityProvider;
import org.hk.doghub.model.tip.DogHubTip;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
public class DogHubTipContentProvider implements EntityProvider<DogHubTip> {

    private final GeneratorService<Tip> generatorService;

    private final Converter<Tip, DogHubTip> converter;

    public @NotNull DogHubTip get() {
        return getTip();
    }

    public @NotNull List<DogHubTip> get(int numberOfItems) {
        return converter.convert(generatorService.generate(numberOfItems));
    }

    private @NotNull DogHubTip getTip() {
        return converter.convert(generatorService.generate());
    }
}
