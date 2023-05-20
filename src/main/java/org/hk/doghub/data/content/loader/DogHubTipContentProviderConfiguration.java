package org.hk.doghub.data.content.loader;

import jakarta.validation.constraints.Positive;
import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@Configuration
@PropertySource("classpath:tip-content-provider-configuration.properties")
@ConfigurationProperties(prefix = "tip.content.provider")
@Data
public class DogHubTipContentProviderConfiguration {

    @Positive
    private Integer numberOfItems = 500;
}
