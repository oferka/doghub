package org.hk.doghub.automation.e2e.selenium.ui.actions.click;

import jakarta.validation.constraints.NotNull;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.hk.doghub.automation.e2e.selenium.element.highlight.ElementHighlighter;
import org.hk.doghub.automation.e2e.selenium.element.retrieve.ElementRetriever;
import org.hk.doghub.automation.e2e.selenium.info.screenshot.ScreenshotExecutor;
import org.hk.doghub.automation.e2e.selenium.ui.actions.pause.PauseExecutor;
import org.hk.doghub.automation.e2e.selenium.ui.actions.popup.PopupRemover;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.springframework.stereotype.Service;

@Service
@Slf4j
@RequiredArgsConstructor
public class DefaultClickExecutor implements ClickExecutor {

    private final ElementRetriever elementRetriever;

    private final ElementHighlighter elementHighlighter;

    private final PauseExecutor pauseExecutor;

    private final ScreenshotExecutor screenshotExecutor;

    private final ClickExecutorConfiguration clickExecutorConfiguration;

    private final PopupRemover popupRemover;

    private final ClickSoundPlayer clickSoundPlayer;

    @Override
    public void click(@NotNull WebDriver webDriver, @NotNull By locator) {
        click(webDriver, elementRetriever.getByClickable(webDriver, locator));
    }

    @Override
    public void click(@NotNull WebDriver webDriver, @NotNull WebElement element) {
        log.info("Element click started");
        elementHighlighter.eventHighlight(webDriver, element);
        screenshotExecutor.execute(webDriver, clickExecutorConfiguration.isTakeScreenshot());
        popupRemover.remove(webDriver);
        clickSoundPlayer.play();
        element.click();
        pauseExecutor.pause();
        log.info("Element click completed");
    }
}
