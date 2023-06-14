package org.hk.doghub.data.content.provider.user;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.hk.doghub.data.content.generator.GeneratorService;
import org.hk.doghub.data.content.generator.user.User;
import org.hk.doghub.data.content.provider.AbstractEntityProvider;
import org.hk.doghub.data.content.provider.Converter;
import org.hk.doghub.model.user.DogHubUser;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Slf4j
public class DogHubUserContentProvider extends AbstractEntityProvider<User, DogHubUser> {

    private final GeneratorService<User> generatorService;

    private final Converter<User, DogHubUser> converter;

    @Override
    protected GeneratorService<User> getGeneratorService() {
        return generatorService;
    }

    @Override
    protected Converter<User, DogHubUser> getConverter() {
        return converter;
    }
}
