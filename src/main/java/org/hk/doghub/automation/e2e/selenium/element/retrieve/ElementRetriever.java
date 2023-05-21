package org.hk.doghub.automation.e2e.selenium.element.retrieve;

import jakarta.validation.constraints.NotNull;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public interface ElementRetriever {

    @NotNull WebElement getByPresence(@NotNull WebDriver driver, @NotNull By locator, long timeOutInSeconds);

    @NotNull WebElement getByPresence(@NotNull WebDriver driver, @NotNull By locator);

    @NotNull WebElement getByClickable(@NotNull WebDriver driver, @NotNull By locator, long timeOutInSeconds);

    @NotNull WebElement getByClickable(@NotNull WebDriver driver, @NotNull By locator);
}
