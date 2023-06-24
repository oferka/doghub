package org.hk.doghub.automation.e2e.selenium.ui.actions.text.input;

import jakarta.validation.constraints.NotNull;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public interface TextInputExecutor {

    void enterText(@NotNull WebDriver webDriver, @NotNull By locator, @NotNull String text);

    void enterText(@NotNull WebDriver webDriver, @NotNull By locator, @NotNull String text, boolean enter, boolean oneByOne);

    void enterText(@NotNull WebDriver webDriver, @NotNull WebElement element, @NotNull String text);

    void enterText(@NotNull WebDriver webDriver, @NotNull WebElement element, @NotNull String text, boolean enter, boolean oneByOne);
}
