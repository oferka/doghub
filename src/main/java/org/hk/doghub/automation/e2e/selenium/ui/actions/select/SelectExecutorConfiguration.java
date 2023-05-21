package org.hk.doghub.automation.e2e.selenium.ui.actions.select;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@Configuration
@PropertySource("classpath:automation/e2e/selenium/select-executor.properties")
@ConfigurationProperties(prefix = "select.executor")
@Data
public class SelectExecutorConfiguration {

    private boolean takeScreenshot = true;
}
