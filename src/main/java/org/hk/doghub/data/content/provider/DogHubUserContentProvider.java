package org.hk.doghub.data.content.provider;

import jakarta.validation.constraints.NotNull;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.hk.doghub.data.content.generator.user.service.UserGeneratorService;
import org.hk.doghub.model.DogHubUser;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
public class DogHubUserContentProvider {

    private final UserGeneratorService userGeneratorService;

    private final UserConverter userConverter;

    public @NotNull DogHubUser get() {
        return getUser();
    }

    public List<DogHubUser> get(int numberOfItems) {
        return userConverter.convert(userGeneratorService.generate(numberOfItems));
    }

    private @NotNull DogHubUser getUser() {
        return userConverter.convert(userGeneratorService.generate());
    }
}
