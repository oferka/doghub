package org.hk.doghub.automation.e2e.selenium.element.click.status;

import jakarta.validation.constraints.NotNull;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public interface ElementClickStatusRetriever {

    boolean isClickable(@NotNull WebDriver driver, @NotNull By locator);

    boolean isClickable(@NotNull WebDriver driver, @NotNull By locator, boolean highlightIfClickable);
}
