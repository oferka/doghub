package org.hk.doghub.data.content.provider.tip;

import jakarta.validation.constraints.NotNull;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.hk.doghub.data.content.generator.tip.service.TipGeneratorService;
import org.hk.doghub.model.tip.DogHubTip;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
public class DogHubTipContentProvider {

    private final TipGeneratorService tipGeneratorService;

    private final TipConverter tipConverter;

    public @NotNull DogHubTip get() {
        return getTip();
    }

    public List<DogHubTip> get(int numberOfItems) {
        return tipConverter.convert(tipGeneratorService.generate(numberOfItems));
    }

    private @NotNull DogHubTip getTip() {
        return tipConverter.convert(tipGeneratorService.generate());
    }
}
