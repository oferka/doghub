package org.hk.doghub.automation.e2e.selenium.element.retrieve;

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

@Service
@Slf4j
@RequiredArgsConstructor
public class DefaultElementRetriever implements ElementRetriever {

    private final ElementRetrieverConfiguration elementRetrieverConfiguration;

    public @NotNull WebElement getByPresence(@NotNull WebDriver driver, @NotNull By locator, long timeOutInSeconds) {
        return retrieve(driver, timeOutInSeconds, ExpectedConditions.presenceOfElementLocated(locator));
    }

    @Override
    public @NotNull WebElement getByPresence(@NotNull WebDriver driver, @NotNull By locator) {
        return getByPresence(driver, locator, elementRetrieverConfiguration.getByPresenceDefaultTimeout());
    }

    @Override
    public @NotNull WebElement getByClickable(@NotNull WebDriver driver, @NotNull By locator, long timeOutInSeconds) {
        return retrieve(driver, timeOutInSeconds, ExpectedConditions.elementToBeClickable(locator));
    }

    @Override
    public @NotNull WebElement getByClickable(@NotNull WebDriver driver, @NotNull By locator) {
        return getByClickable(driver, locator, elementRetrieverConfiguration.getByClickableDefaultTimeout());
    }

    private @NotNull WebElement retrieve(@NotNull WebDriver driver, long timeOutInSeconds, @NotNull ExpectedCondition<WebElement> expectedCondition) {
        return new WebDriverWait(driver, Duration.ofSeconds(timeOutInSeconds)).until(expectedCondition);
    }
}
