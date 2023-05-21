package org.hk.doghub.automation.e2e.selenium.ui.actions.click;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@Configuration
@PropertySource("classpath:automation/e2e/selenium/click-executor.properties")
@ConfigurationProperties(prefix = "click.executor")
@Data
public class ClickExecutorConfiguration {

    private boolean takeScreenshot = true;
}
