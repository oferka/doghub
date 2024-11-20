package org.hk.doghub.ui.e2e;

import jakarta.validation.constraints.NotNull;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.web.util.UriComponents;
import org.springframework.web.util.UriComponentsBuilder;

@Service
@Slf4j
@RequiredArgsConstructor
public class DefaultDogHubUriComponentsProvider implements DogHubUriComponentsProvider {

    @NotNull
    private final DogHubUriComponentsProviderConfiguration dogHubUriComponentsProviderConfiguration;

    @Override
    public @NotNull UriComponents get(int port, @NotNull String path) {
        UriComponents result = UriComponentsBuilder
                .newInstance()
                .scheme(dogHubUriComponentsProviderConfiguration.getSchema())
                .host(dogHubUriComponentsProviderConfiguration.getHost())
                .port(port)
                .path(path)
                .build();
        return result;
    }

    @Override
    public @NotNull UriComponents get(@NotNull String path) {
        return get(dogHubUriComponentsProviderConfiguration.getPort(), path);
    }
}
