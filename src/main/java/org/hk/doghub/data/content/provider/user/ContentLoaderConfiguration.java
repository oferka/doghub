package org.hk.doghub.data.content.provider.user;

import org.hk.doghub.data.content.loader.ContentLoader;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ContentLoaderConfiguration {

    @Bean
    public CommandLineRunner loadContent(ContentLoader contentLoader) {
        return args -> contentLoader.ensureContentLoaded();
    }
}
