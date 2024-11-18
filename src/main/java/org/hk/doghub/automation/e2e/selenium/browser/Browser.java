package org.hk.doghub.automation.e2e.selenium.browser;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.*;

@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Getter
public class Browser {

    @NotNull
    private BrowserType type;

    private boolean maximize;

    private boolean headless;

    @Getter
    @AllArgsConstructor
    @ToString
    public enum BrowserType {

        CHROME("chrome"),
        FIREFOX("firefox"),

        EDGE("edge"),
        SAFARI("safari");

        @NotNull
        @Size(min = 2, max = 16)
        @NotBlank
        private final String name;
    }
}
