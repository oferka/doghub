package org.hk.doghub.ui.automation;

import jakarta.validation.constraints.NotNull;
import org.springframework.web.util.UriComponents;

public interface DogHubUriComponentsProvider {

    @NotNull
    UriComponents get(int port, @NotNull String path);

    @NotNull
    UriComponents get(@NotNull String path);
}
