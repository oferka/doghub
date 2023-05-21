package org.hk.doghub.automation.e2e.selenium.ui.actions.alert;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@Configuration
@PropertySource("classpath:automation/e2e/selenium/confirm-box-executor.properties")
@ConfigurationProperties(prefix = "confirm.box.executor")
@Data
public class ConfirmBoxExecutorConfiguration {

    private int numberOfSecondsToWaitForAlert = 5;
}
