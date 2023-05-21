package org.hk.doghub.automation.e2e.selenium.ui.actions.click;

import jakarta.validation.constraints.NotNull;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public interface ClickExecutor {

    void click(@NotNull WebDriver webDriver, @NotNull By locator);

    void click(@NotNull WebDriver webDriver, @NotNull WebElement element);
}
