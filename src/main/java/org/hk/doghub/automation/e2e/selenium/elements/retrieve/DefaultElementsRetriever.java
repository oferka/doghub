package org.hk.doghub.automation.e2e.selenium.elements.retrieve;

import jakarta.validation.constraints.NotNull;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.springframework.stereotype.Service;

import java.time.Duration;
import java.util.List;

@Service
@Slf4j
@RequiredArgsConstructor
public class DefaultElementsRetriever implements ElementsRetriever {

    private final ElementsRetrieverConfiguration elementsRetrieverConfiguration;

    public @NotNull List<WebElement> getByPresence(@NotNull WebDriver driver, @NotNull By locator, long timeOutInSeconds) {
        return retrieve(driver, timeOutInSeconds, ExpectedConditions.presenceOfAllElementsLocatedBy(locator));
    }

    @Override
    public @NotNull List<WebElement> getByPresence(@NotNull WebDriver driver, @NotNull By locator) {
        return getByPresence(driver, locator, elementsRetrieverConfiguration.getByPresenceDefaultTimeout());
    }

    @Override
    public @NotNull List<WebElement> getByVisibility(@NotNull WebDriver driver, @NotNull By locator, long timeOutInSeconds) {
        return retrieve(driver, timeOutInSeconds, ExpectedConditions.visibilityOfAllElementsLocatedBy(locator));
    }

    @Override
    public @NotNull List<WebElement> getByVisibility(@NotNull WebDriver driver, @NotNull By locator) {
        return getByVisibility(driver, locator, elementsRetrieverConfiguration.getByVisibilityDefaultTimeout());
    }

    private @NotNull List<WebElement> retrieve(@NotNull WebDriver driver, long timeOutInSeconds, @NotNull ExpectedCondition<List<WebElement>> expectedCondition) {
        return new WebDriverWait(driver, Duration.ofSeconds(timeOutInSeconds)).until(expectedCondition);
    }
}
