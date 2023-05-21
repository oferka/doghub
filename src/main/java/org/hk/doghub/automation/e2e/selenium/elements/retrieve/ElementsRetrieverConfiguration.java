package org.hk.doghub.automation.e2e.selenium.elements.retrieve;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@Configuration
@PropertySource("classpath:automation/e2e/selenium/elements-retriever.properties")
@ConfigurationProperties(prefix = "elements.retriever")
@Data
public class ElementsRetrieverConfiguration {

    private long byPresenceDefaultTimeout = 5;
    private long byVisibilityDefaultTimeout = 5;
}
