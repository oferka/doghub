package org.hk.doghub.automation.e2e.selenium.browser;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

import static org.hk.doghub.automation.e2e.selenium.browser.Browser.BrowserType.CHROME;

@Configuration
@PropertySource("classpath:automation/e2e/selenium/browser.properties")
@ConfigurationProperties(prefix = "browser")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class BrowserConfiguration {

    private Browser.BrowserType type = CHROME;

    private boolean maximizeWindow = false;

    private boolean headless = false;
}
