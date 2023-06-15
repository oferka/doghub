package org.hk.doghub.data.content.loader;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ContentLoaderConfiguration {

    @Bean
    public CommandLineRunner loadContent(ContentLoader contentLoader) {
        return args -> contentLoader.load();
    }
}
