package org.hk.doghub.automation.e2e.selenium.ui.actions.select;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public interface SelectExecutor {

    void selectByVisibleText(@NotNull WebDriver webDriver, @NotNull By locator, @NotNull @NotBlank String text);

    void selectByValue(@NotNull WebDriver webDriver, @NotNull By locator, @NotNull @NotBlank String value);

    void selectByIndex(@NotNull WebDriver webDriver, @NotNull By locator, int index);

    void selectRandom(@NotNull WebDriver webDriver, @NotNull By locator);
}
