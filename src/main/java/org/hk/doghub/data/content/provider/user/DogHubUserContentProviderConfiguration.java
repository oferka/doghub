package org.hk.doghub.data.content.provider.user;

import org.hk.doghub.data.content.provider.EntityProviderConfiguration;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@Configuration
@PropertySource("classpath:user-content-provider-configuration.properties")
@ConfigurationProperties(prefix = "user.content.provider")
public class DogHubUserContentProviderConfiguration extends EntityProviderConfiguration {
}
