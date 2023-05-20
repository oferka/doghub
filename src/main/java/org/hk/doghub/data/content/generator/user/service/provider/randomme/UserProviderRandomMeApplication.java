package org.hk.doghub.data.content.generator.user.service.provider.randomme;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication(scanBasePackages = "org.ok.usa")
public class UserProviderRandomMeApplication {

    public static void main(String[] args) {
        SpringApplication.run(UserProviderRandomMeApplication.class, args);
    }

    @Bean
    public RestTemplate restTemplate(RestTemplateBuilder builder) {
        return builder.build();
    }
}