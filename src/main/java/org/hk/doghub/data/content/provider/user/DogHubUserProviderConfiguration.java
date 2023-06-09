package org.hk.doghub.data.content.provider.user;

import org.hk.doghub.data.content.provider.EntityProviderConfiguration;
import org.hk.doghub.model.user.DogHubUser;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@Configuration
@PropertySource("classpath:user-provider-configuration.properties")
@ConfigurationProperties(prefix = "user.provider")
public class DogHubUserProviderConfiguration extends EntityProviderConfiguration<DogHubUser> {
}
