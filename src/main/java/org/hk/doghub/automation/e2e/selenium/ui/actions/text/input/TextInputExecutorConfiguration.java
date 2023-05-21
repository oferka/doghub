package org.hk.doghub.automation.e2e.selenium.ui.actions.text.input;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@Configuration
@PropertySource("classpath:automation/e2e/selenium/text-input-executor.properties")
@ConfigurationProperties(prefix = "text.input")
@Data
public class TextInputExecutorConfiguration {

    private boolean takeScreenshotBefore = false;

    private boolean takeScreenshotAfter = true;
}
