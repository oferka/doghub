package org.hk.doghub.automation.e2e.selenium.element.display.status;

import jakarta.validation.constraints.NotNull;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public interface ElementDisplayStatusRetriever {

    boolean isDisplayed(@NotNull WebDriver driver, @NotNull By locator);

    boolean isDisplayed(@NotNull WebDriver driver, @NotNull By locator, boolean highlightIfDisplayed);

    boolean isDisplayed(@NotNull WebDriver driver, @NotNull By parentLocator, @NotNull By locator, boolean highlightIfDisplayed);
}
