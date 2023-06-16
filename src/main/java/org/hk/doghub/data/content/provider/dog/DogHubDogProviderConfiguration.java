package org.hk.doghub.data.content.provider.dog;

import org.hk.doghub.data.content.provider.EntityProviderConfiguration;
import org.hk.doghub.model.dog.DogHubDog;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@Configuration
@PropertySource("classpath:dog-provider-configuration.properties")
@ConfigurationProperties(prefix = "dog.provider")
public class DogHubDogProviderConfiguration extends EntityProviderConfiguration<DogHubDog> {
}
