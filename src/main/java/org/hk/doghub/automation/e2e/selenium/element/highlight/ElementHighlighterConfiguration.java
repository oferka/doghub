package org.hk.doghub.automation.e2e.selenium.element.highlight;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@Configuration
@PropertySource("classpath:automation/e2e/selenium/element-highlighter.properties")
@ConfigurationProperties(prefix = "element.highlighter")
@Data
public class ElementHighlighterConfiguration {

    private boolean enabled = true;

    @NotNull
    @NotBlank
    @Size(min = 2, max = 32)
    private String color = "navy";

    @NotNull
    @NotBlank
    @Size(min = 2, max = 32)
    private String background = "silver";

    @NotNull
    @NotBlank
    @Size(min = 2, max = 32)
    private String border = "1px solid navy";

    @NotNull
    @NotBlank
    @Size(min = 2, max = 32)
    private String eventColor = "navy";

    @NotNull
    @NotBlank
    @Size(min = 2, max = 32)
    private String eventBackground = "yellow";

    @NotNull
    @NotBlank
    @Size(min = 2, max = 32)
    private String eventBorder = "1px solid navy";
}
