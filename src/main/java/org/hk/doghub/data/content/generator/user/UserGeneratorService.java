package org.hk.doghub.data.content.generator.user;

import jakarta.validation.constraints.NotNull;
import lombok.RequiredArgsConstructor;
import org.hk.doghub.data.content.generator.GeneratorService;
import org.hk.doghub.data.content.generator.Provider;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

@Service
@RequiredArgsConstructor
@Validated
public class UserGeneratorService extends GeneratorService<User> {

    private final Provider<User> provider;

    @Override
    protected @NotNull Provider<User> getProvider() {
        return provider;
    }
}
