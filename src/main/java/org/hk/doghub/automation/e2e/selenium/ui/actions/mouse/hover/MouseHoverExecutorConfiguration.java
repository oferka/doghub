package org.hk.doghub.automation.e2e.selenium.ui.actions.mouse.hover;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@Configuration
@PropertySource("classpath:automation/e2e/selenium/mouse-hover-executor.properties")
@ConfigurationProperties(prefix = "mouse.hover")
@Data
public class MouseHoverExecutorConfiguration {

    private boolean takeScreenshot = false;
}
