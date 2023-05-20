package org.hk.doghub.automation.e2e.selenium.mapping.destination;

import jakarta.validation.constraints.NotNull;
import org.springframework.web.util.UriComponents;

public interface UriComponentsProvider {

    @NotNull
    UriComponents get(int port, @NotNull String path);

    @NotNull
    UriComponents get(@NotNull String path);
}
