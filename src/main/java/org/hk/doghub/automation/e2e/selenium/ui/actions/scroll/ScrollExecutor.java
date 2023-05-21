package org.hk.doghub.automation.e2e.selenium.ui.actions.scroll;

import jakarta.validation.constraints.NotNull;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public interface ScrollExecutor {

    void scroll(@NotNull WebDriver driver, @NotNull ScrollInstructions scrollInstructions);

    void scroll(@NotNull WebDriver driver, @NotNull WebElement webElement);

    void scroll(@NotNull WebDriver driver, @NotNull By locator);
}
