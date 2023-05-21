package org.hk.doghub.automation.e2e.selenium.ui.actions.popup;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@Configuration
@PropertySource("classpath:automation/e2e/selenium/popup-remover.properties")
@ConfigurationProperties(prefix = "popup.remover")
@Data
public class PopupRemoverConfiguration {

    private boolean enabled = false;

    private String xpath = "//div[@title='Stop Walk-thru']";
}
