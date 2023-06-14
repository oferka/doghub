package org.hk.doghub.data.content.provider.user;

import jakarta.validation.constraints.NotNull;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.hk.doghub.data.content.generator.GeneratorService;
import org.hk.doghub.data.content.generator.user.User;
import org.hk.doghub.data.content.provider.Converter;
import org.hk.doghub.model.user.DogHubUser;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
public class DogHubUserContentProvider {

    private final GeneratorService<User> generatorService;

    private final Converter<User, DogHubUser> converter;

    public @NotNull DogHubUser get() {
        return getUser();
    }

    public List<DogHubUser> get(int numberOfItems) {
        return converter.convert(generatorService.generate(numberOfItems));
    }

    private @NotNull DogHubUser getUser() {
        return converter.convert(generatorService.generate());
    }
}
