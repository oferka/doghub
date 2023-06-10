package org.hk.doghub.automation.e2e.selenium.element.click.status;

import jakarta.validation.constraints.NotNull;
import lombok.extern.slf4j.Slf4j;
import org.hk.doghub.automation.e2e.selenium.element.highlight.ElementHighlighter;
import org.hk.doghub.automation.e2e.selenium.element.retrieve.ElementRetriever;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class DefaultElementClickStatusRetriever implements ElementClickStatusRetriever {

    @Autowired
    @NotNull
    private ElementRetriever elementRetriever;

    @Autowired
    @NotNull
    private ElementHighlighter elementHighlighter;

    @Override
    public boolean isClickable(@NotNull WebDriver driver, @NotNull By locator) {
        return isClickable(driver, locator, false);
    }

    @Override
    public boolean isClickable(@NotNull WebDriver driver, @NotNull By locator, boolean highlightIfClickable) {
        log.info("Check if element is currently clickable started");
        boolean result;
        try {
            log.debug("Using locator '{}'", locator);
            WebElement element = elementRetriever.getByClickable(driver, locator, 1L);
            log.debug("Found element");
            if(highlightIfClickable) {
                elementHighlighter.highlight(driver, element);
            }
            result = true;
        }
        catch (Exception e) {
            log.debug("Failed to find element. Error message was '{}'", e.getMessage());
            result = false;
        }
        log.info("Check if element is currently clickable completed. result is: {}", result);
        return result;
    }
}
