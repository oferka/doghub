package org.hk.doghub.automation.e2e.selenium.element.highlight;

import jakarta.validation.constraints.NotNull;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.hk.doghub.automation.e2e.selenium.element.retrieve.ElementRetriever;
import org.hk.doghub.automation.e2e.selenium.ui.actions.pause.PauseExecutor;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.springframework.stereotype.Service;

import static java.lang.String.format;

@Service
@Slf4j
@RequiredArgsConstructor
public class DefaultElementHighlighter implements ElementHighlighter {

    private final ElementHighlighterConfiguration elementHighlighterConfiguration;

    private final PauseExecutor pauseExecutor;

    private final ElementRetriever elementRetriever;

    @Override
    public void highlight(@NotNull WebDriver driver, @NotNull WebElement element) {
        log.debug("Element highlighting started");
        if(elementHighlighterConfiguration.isEnabled()) {
            JavascriptExecutor js = (JavascriptExecutor) driver;
            String script = format(
                    "arguments[0].setAttribute('style', 'color: %s; background: %s; border: %s;');",
                    elementHighlighterConfiguration.getColor(),
                    elementHighlighterConfiguration.getBackground(),
                    elementHighlighterConfiguration.getBorder()
            );
            js.executeScript(script, element);
            pauseExecutor.pause();
        }
        else {
            log.debug("Element highlighter is not enabled");
        }
        log.debug("Element highlighting completed");
    }

    @Override
    public void highlight(@NotNull WebDriver driver, @NotNull By locator) {
        highlight(driver, elementRetriever.getByPresence(driver, locator));
    }

    @Override
    public void eventHighlight(@NotNull WebDriver driver, @NotNull WebElement element) {
        log.debug("Element event highlighting started");
        if(elementHighlighterConfiguration.isEnabled()) {
            JavascriptExecutor js = (JavascriptExecutor) driver;
            String highlightScript = format(
                    "arguments[0].setAttribute('style', 'color: %s; background: %s; border: %s;');",
                    elementHighlighterConfiguration.getColor(),
                    elementHighlighterConfiguration.getBackground(),
                    elementHighlighterConfiguration.getBorder()
            );
            String eventHighlightScript = format(
                    "arguments[0].setAttribute('style', 'color: %s; background: %s; border: %s;');",
                    elementHighlighterConfiguration.getEventColor(),
                    elementHighlighterConfiguration.getEventBackground(),
                    elementHighlighterConfiguration.getEventBorder()
            );
            for(int i=0; i<5; i++) {
                try {
                    js.executeScript(eventHighlightScript, element);
                    Thread.sleep(100);
                    js.executeScript(highlightScript, element);
                    Thread.sleep(100);
                }
                catch (InterruptedException e) {
                    log.error(e.getMessage(), e);
                }
            }
            pauseExecutor.pause();
        }
        else {
            log.debug("Element highlighter is not enabled");
        }
        log.debug("Element event highlighting completed");
    }

    @Override
    public void eventHighlight(@NotNull WebDriver driver, @NotNull By locator) {
        eventHighlight(driver, elementRetriever.getByPresence(driver, locator));
    }
}
