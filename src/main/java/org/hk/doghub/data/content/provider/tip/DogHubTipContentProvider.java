package org.hk.doghub.data.content.provider.tip;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.hk.doghub.data.content.generator.GeneratorService;
import org.hk.doghub.data.content.generator.tip.Tip;
import org.hk.doghub.data.content.provider.AbstractEntityProvider;
import org.hk.doghub.data.content.provider.Converter;
import org.hk.doghub.model.tip.DogHubTip;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Slf4j
public class DogHubTipContentProvider extends AbstractEntityProvider<Tip, DogHubTip> {

    private final GeneratorService<Tip> generatorService;

    private final Converter<Tip, DogHubTip> converter;

    @Override
    protected GeneratorService<Tip> getGeneratorService() {
        return generatorService;
    }

    @Override
    protected Converter<Tip, DogHubTip> getConverter() {
        return converter;
    }
}
