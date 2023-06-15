package org.hk.doghub.data.content.loader.tip;

import org.hk.doghub.data.content.provider.EntityProviderConfiguration;
import org.hk.doghub.model.tip.DogHubTip;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@Configuration
@PropertySource("classpath:tip-provider-configuration.properties")
@ConfigurationProperties(prefix = "tip.provider")
public class DogHubTipProviderConfiguration extends EntityProviderConfiguration<DogHubTip> {
}
