package org.hk.doghub.automation.e2e.selenium.element.highlight;

import jakarta.validation.constraints.NotNull;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public interface ElementHighlighter {

    void highlight(@NotNull WebDriver driver, @NotNull WebElement element);

    void highlight(@NotNull WebDriver driver, @NotNull By locator);

    void eventHighlight(@NotNull WebDriver driver, @NotNull WebElement element);

    void eventHighlight(@NotNull WebDriver driver, @NotNull By locator);
}
