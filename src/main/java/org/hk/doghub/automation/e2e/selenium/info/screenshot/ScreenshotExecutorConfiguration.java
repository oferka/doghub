package org.hk.doghub.automation.e2e.selenium.info.screenshot;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@Configuration
@PropertySource("classpath:automation/e2e/selenium/screenshot-executor.properties")
@ConfigurationProperties(prefix = "screenshot.executor")
@Data
public class ScreenshotExecutorConfiguration {

    private boolean enabled = true;
}
