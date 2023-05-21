package org.hk.doghub.automation.e2e.selenium.page;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@Configuration
@PropertySource("classpath:automation/e2e/selenium/title-verifier.properties")
@ConfigurationProperties(prefix = "title.verifier")
@Data
public class TitleVerifierConfiguration {

    private long timeOutInSeconds = 12L;
}
