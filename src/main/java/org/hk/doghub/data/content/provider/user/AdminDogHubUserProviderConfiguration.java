package org.hk.doghub.data.content.provider.user;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@Configuration
@PropertySource("classpath:admin-user.properties")
@ConfigurationProperties(prefix = "admin.user")
@Data
public class AdminDogHubUserProviderConfiguration {

    private String name;
    private String username;
    private String email;
}
