package org.hk.doghub.automation.e2e.selenium.ui.actions.mouse.hover;

import jakarta.validation.constraints.NotNull;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public interface MouseHoverExecutor {

    void hover(@NotNull WebDriver webDriver, @NotNull By locator);

    void hover(@NotNull WebDriver webDriver, @NotNull WebElement element);
}
