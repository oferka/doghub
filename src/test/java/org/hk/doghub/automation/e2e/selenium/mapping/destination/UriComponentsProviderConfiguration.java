package org.hk.doghub.automation.e2e.selenium.mapping.destination;

import jakarta.validation.constraints.NotNull;
import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@Configuration
@PropertySource("classpath:uri-components.properties")
@ConfigurationProperties(prefix = "uri.component")
@Data
public class UriComponentsProviderConfiguration {

    @NotNull
    private String schema = "http";

    @NotNull
    private String host = "automationexercise.com";

    private int port = 80;
}
