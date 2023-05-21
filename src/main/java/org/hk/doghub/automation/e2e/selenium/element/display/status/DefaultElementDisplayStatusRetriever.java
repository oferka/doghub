package org.hk.doghub.automation.e2e.selenium.element.display.status;

import jakarta.validation.constraints.NotNull;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.hk.doghub.automation.e2e.selenium.element.highlight.ElementHighlighter;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.pagefactory.ByChained;
import org.springframework.stereotype.Service;

@Service
@Slf4j
@RequiredArgsConstructor
public class DefaultElementDisplayStatusRetriever implements ElementDisplayStatusRetriever {

    private final ElementHighlighter elementHighlighter;

    @Override
    public boolean isDisplayed(@NotNull WebDriver driver, @NotNull By locator) {
        return isDisplayed(driver, locator, false);
    }

    @Override
    public boolean isDisplayed(@NotNull WebDriver driver, @NotNull By locator, boolean highlightIfDisplayed) {
        log.info("Check if element is currently displayed started");
        boolean result;
        try {
            log.debug("Using locator '{}'", locator.toString());
            WebElement element = driver.findElement(locator);
            log.debug("Found element");
            result = element.isDisplayed();
            if(result && highlightIfDisplayed) {
                elementHighlighter.highlight(driver, element);
            }
        }
        catch (Exception e) {
            log.debug("Failed to find element. Error message was '{}'", e.getMessage());
            result = false;
        }
        log.info("Check if element is currently displayed completed. result is: {}", result);
        return result;
    }

    @Override
    public boolean isDisplayed(@NotNull WebDriver driver, @NotNull By parentLocator, @NotNull By locator, boolean highlightIfDisplayed) {
        log.info("Check if element is currently displayed under specified parent started");
        boolean result;
        try {
            WebElement element = driver.findElement(new ByChained(parentLocator, locator));
            result = element.isDisplayed();
            if(result && highlightIfDisplayed) {
                elementHighlighter.highlight(driver, element);
            }
        }
        catch (Exception e) {
            log.debug("Failed to find element. Error message was '{}'", e.getMessage());
            result = false;
        }
        log.info(
                "Check if element is currently displayed under specified parent completed. result is: {}",
                result
        );
        return result;
    }
}
