package org.hk.doghub.data.content.generator.user.service;

import lombok.RequiredArgsConstructor;
import org.hk.doghub.data.content.generator.GeneratorService;
import org.hk.doghub.data.content.generator.Provider;
import org.hk.doghub.data.content.generator.user.model.User;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

@Service
@RequiredArgsConstructor
@Validated
public class UserGeneratorService extends GeneratorService<User> {

    private final UserProvider provider;

    @Override
    protected Provider<User> getProvider() {
        return provider;
    }
}
