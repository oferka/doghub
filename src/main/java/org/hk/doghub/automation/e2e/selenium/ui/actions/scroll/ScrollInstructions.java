package org.hk.doghub.automation.e2e.selenium.ui.actions.scroll;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.PositiveOrZero;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

@AllArgsConstructor
@NoArgsConstructor
@ToString
public class ScrollInstructions {

    @Getter
    private ScrollDirections direction;

    @Getter
    private int pixels;

    @Getter
    private ScrollSpeeds speed;

    @ToString
    @AllArgsConstructor
    public enum ScrollDirections {

        UP ("Up"),
        DOWN("Down");

        @Getter
        @NotNull
        @Size(min = 2, max = 16)
        @NotBlank
        private final String name;
    }

    @ToString
    @AllArgsConstructor
    public enum ScrollSpeeds {

        FAST ("Fast", 100),
        MEDIUM("Medium", 250),
        SLOW("Slow", 1000);

        @Getter
        @NotNull
        @Size(min = 2, max = 16)
        @NotBlank
        private final String name;

        @Getter
        @PositiveOrZero
        private final long delayInMilliSeconds;
    }
}
