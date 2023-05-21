package org.hk.doghub.automation.e2e.selenium.elements.retrieve;

import jakarta.validation.constraints.NotNull;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public interface ElementsRetriever {

    @NotNull List<WebElement> getByPresence(@NotNull WebDriver driver, @NotNull By locator, long timeOutInSeconds);

    @NotNull List<WebElement> getByPresence(@NotNull WebDriver driver, @NotNull By locator);

    @NotNull List<WebElement> getByVisibility(@NotNull WebDriver driver, @NotNull By locator, long timeOutInSeconds);

    @NotNull List<WebElement> getByVisibility(@NotNull WebDriver driver, @NotNull By locator);
}
