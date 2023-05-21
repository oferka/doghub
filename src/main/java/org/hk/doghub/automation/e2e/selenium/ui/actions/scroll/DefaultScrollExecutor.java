package org.hk.doghub.automation.e2e.selenium.ui.actions.scroll;

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

import java.time.Duration;

import static java.lang.String.format;
import static org.hk.doghub.automation.e2e.selenium.ui.actions.scroll.ScrollInstructions.ScrollDirections.UP;

@Service
@RequiredArgsConstructor
@Slf4j
public class DefaultScrollExecutor implements ScrollExecutor {

    private final PauseExecutor pauseExecutor;

    private final ElementRetriever elementRetriever;

    @Override
    public void scroll(@NotNull WebDriver driver, @NotNull ScrollInstructions scrollInstructions) {
        log.debug("Scroll by instructions '{}' started", scrollInstructions.toString());
        JavascriptExecutor js = (JavascriptExecutor) driver;
        int numberOfSteps = 10;
        int signedPixels = getSignedScroll(
                scrollInstructions.getDirection(),
                scrollInstructions.getPixels()
        );
        int stepSize = signedPixels/numberOfSteps;
        for(int i=0; i<numberOfSteps; i++) {
            scroll(driver, stepSize);
            pauseExecutor.pause(Duration.ofMillis(scrollInstructions.getSpeed().getDelayInMilliSeconds()));
        }
        stepSize = signedPixels%numberOfSteps;
        if(stepSize != 0) {
            String script = format("window.scrollBy(0,%s)", stepSize);
            js.executeScript(script);
        }
        log.debug("Scroll by instructions '{}' completed", scrollInstructions);
    }

    @Override
    public void scroll(@NotNull WebDriver driver, @NotNull WebElement element) {
        log.debug("Scroll to element started");
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView(false);", element);
        log.debug("Scroll to element completed");
    }

    @Override
    public void scroll(@NotNull WebDriver driver, @NotNull By locator) {
        log.debug("Scroll to locator started");
        scroll(driver, elementRetriever.getByPresence(driver, locator));
        log.debug("Scroll to locator completed");
    }

    private int getSignedScroll(@NotNull ScrollInstructions.ScrollDirections direction, int pixels) {
        int result = pixels;
        if(direction == UP) {
            result = pixels * -1;
        }
        return result;
    }

    private void scroll(@NotNull WebDriver driver, int signedPixels) {
        log.debug("Scroll by '{}' started", signedPixels);
        JavascriptExecutor js = (JavascriptExecutor) driver;
        String script = format("window.scrollBy(0,%s)", signedPixels);
        js.executeScript(script);
        log.debug("Scroll by '{}' completed", signedPixels);
    }
}
