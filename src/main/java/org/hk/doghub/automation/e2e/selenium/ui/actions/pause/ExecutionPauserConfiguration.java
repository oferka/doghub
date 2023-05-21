package org.hk.doghub.automation.e2e.selenium.ui.actions.pause;

import jakarta.validation.constraints.PositiveOrZero;
import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@Configuration
@PropertySource("classpath:automation/e2e/selenium/execution-pause.properties")
@ConfigurationProperties(prefix = "execution.pause")
@Data
public class ExecutionPauserConfiguration {

    private boolean enabled = true;

    @PositiveOrZero
    private long defaultDelayInMillis = 10;
}
