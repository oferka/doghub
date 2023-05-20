package org.hk.doghub.data.content.loader.user;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AdminContentLoaderConfiguration {

    @Bean
    public CommandLineRunner loadAdminContent(AdminDogHubUserContentLoader contentLoader) {
        return args -> contentLoader.ensureContentLoaded();
    }
}
