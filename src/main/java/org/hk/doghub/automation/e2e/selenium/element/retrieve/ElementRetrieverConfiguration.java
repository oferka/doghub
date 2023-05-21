package org.hk.doghub.automation.e2e.selenium.element.retrieve;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@Configuration
@PropertySource("classpath:automation/e2e/selenium/element-retriever.properties")
@ConfigurationProperties(prefix = "element.retriever")
@Data
public class ElementRetrieverConfiguration {

    private long byPresenceDefaultTimeout = 5;
    private long byClickableDefaultTimeout = 5;
}
