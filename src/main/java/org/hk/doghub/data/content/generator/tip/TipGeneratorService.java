package org.hk.doghub.data.content.generator.tip;

import jakarta.validation.constraints.NotNull;
import lombok.RequiredArgsConstructor;
import org.hk.doghub.data.content.generator.GeneratorService;
import org.hk.doghub.data.content.generator.Provider;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

@Service
@RequiredArgsConstructor
@Validated
public class TipGeneratorService extends GeneratorService<Tip> {

    private final Provider<Tip> provider;

    @Override
    protected @NotNull Provider<Tip> getProvider() {
        return provider;
    }
}
