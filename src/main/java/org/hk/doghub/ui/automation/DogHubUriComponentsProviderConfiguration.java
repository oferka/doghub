package org.hk.doghub.ui.automation;

import jakarta.validation.constraints.NotNull;
import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@Configuration
@PropertySource("classpath:dog-hub-uri-components.properties")
@ConfigurationProperties(prefix = "dog.hub.uri.component")
@Data
public class DogHubUriComponentsProviderConfiguration {

    @NotNull
    private String schema = "http";

    @NotNull
    private String host = "localhost";

    private int port = 3764;
}
