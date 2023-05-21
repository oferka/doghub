package org.hk.doghub.automation.e2e.selenium.browser;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Browser {

    @Getter
    @Setter
    @NotNull
    private BrowserType type;

    @Getter
    @Setter
    private boolean maximize;

    @Getter
    @Setter
    private boolean headless;

    @AllArgsConstructor
    @ToString
    public enum BrowserType {

        CHROME("chrome"),
        FIREFOX("firefox"),

        EDGE("edge"),
        SAFARI("safari");

        @Getter
        @NotNull
        @Size(min = 2, max = 16)
        @NotBlank
        private final String name;
    }
}
