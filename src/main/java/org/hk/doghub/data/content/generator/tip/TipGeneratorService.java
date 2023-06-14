package org.hk.doghub.data.content.generator.tip;

import lombok.RequiredArgsConstructor;
import org.hk.doghub.data.content.generator.GeneratorService;
import org.hk.doghub.data.content.generator.Provider;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

@Service
@RequiredArgsConstructor
@Validated
public class TipGeneratorService extends GeneratorService<Tip> {

    private final TipProvider provider;

    @Override
    protected Provider<Tip> getProvider() {
        return provider;
    }
}
