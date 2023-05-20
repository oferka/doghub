package org.hk.doghub.data.content.provider.user;

import jakarta.validation.constraints.Positive;
import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@Configuration
@PropertySource("classpath:user-content-provider-configuration.properties")
@ConfigurationProperties(prefix = "user.content.provider")
@Data
public class DogHubUserContentProviderConfiguration {

    @Positive
    private Integer numberOfItems = 500;
}
