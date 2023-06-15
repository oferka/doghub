package org.hk.doghub.data.content.loader.tip;

import org.hk.doghub.data.content.provider.EntityProviderConfiguration;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@Configuration
@PropertySource("classpath:tip-content-provider-configuration.properties")
@ConfigurationProperties(prefix = "tip.content.provider")
public class DogHubTipContentProviderConfiguration extends EntityProviderConfiguration {
}
