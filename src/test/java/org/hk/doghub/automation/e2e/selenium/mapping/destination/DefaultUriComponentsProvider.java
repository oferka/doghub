package org.hk.doghub.automation.e2e.selenium.mapping.destination;

import jakarta.validation.constraints.NotNull;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.web.util.UriComponents;
import org.springframework.web.util.UriComponentsBuilder;

@Service
@Slf4j
@RequiredArgsConstructor
public class DefaultUriComponentsProvider implements UriComponentsProvider {

    @NotNull
    private final UriComponentsProviderConfiguration uriComponentsProviderConfiguration;

    @Override
    public @NotNull UriComponents get(int port, @NotNull String path) {
        log.info("Get Uri components started");
        UriComponents result = UriComponentsBuilder
                .newInstance()
                .scheme(uriComponentsProviderConfiguration.getSchema())
                .host(uriComponentsProviderConfiguration.getHost())
                .port(port)
                .path(path)
                .build();
        log.info("Get Uri components completed. Result is {}", result);
        return result;
    }

    @Override
    public @NotNull UriComponents get(@NotNull String path) {
        return get(uriComponentsProviderConfiguration.getPort(), path);
    }
}
