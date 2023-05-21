package org.hk.doghub.automation.e2e.selenium.ui.actions.mouse.hover;

import jakarta.validation.constraints.NotNull;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.hk.doghub.automation.e2e.selenium.element.retrieve.ElementRetriever;
import org.hk.doghub.automation.e2e.selenium.info.screenshot.ScreenshotExecutor;
import org.hk.doghub.automation.e2e.selenium.ui.actions.pause.PauseExecutor;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Slf4j
public class DefaultMouseHoverExecutor implements MouseHoverExecutor {

    private final PauseExecutor pauseExecutor;

    private final ScreenshotExecutor screenshotExecutor;

    private final ElementRetriever elementRetriever;

    private final MouseHoverExecutorConfiguration mouseHoverExecutorConfiguration;

    @Override
    public void hover(@NotNull WebDriver webDriver, @NotNull By locator) {
        hover(webDriver, elementRetriever.getByPresence(webDriver, locator));
    }

    @Override
    public void hover(@NotNull WebDriver webDriver, @NotNull WebElement element) {
        log.debug("Mouse hover started");
        screenshotExecutor.execute(webDriver, mouseHoverExecutorConfiguration.isTakeScreenshot());
        Actions actions = new Actions(webDriver);
        actions.moveToElement(element).perform();
        pauseExecutor.pause();
        log.debug("Mouse hover completed");
    }
}
