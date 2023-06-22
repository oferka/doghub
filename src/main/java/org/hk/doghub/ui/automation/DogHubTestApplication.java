package org.hk.doghub.ui.automation;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = { "org.hk.doghub.ui.automation", "org.hk.doghub.automation" })
public class DogHubTestApplication {

    public static void main(String[] args) {
        SpringApplication.run(DogHubTestApplication.class, args);
    }
}
