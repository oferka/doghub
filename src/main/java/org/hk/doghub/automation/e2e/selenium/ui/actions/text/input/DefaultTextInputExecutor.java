package org.hk.doghub.automation.e2e.selenium.ui.actions.text.input;

import jakarta.validation.constraints.NotNull;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.hk.doghub.automation.e2e.selenium.element.highlight.ElementHighlighter;
import org.hk.doghub.automation.e2e.selenium.element.keys.sender.ElementKeysSender;
import org.hk.doghub.automation.e2e.selenium.element.retrieve.ElementRetriever;
import org.hk.doghub.automation.e2e.selenium.info.screenshot.ScreenshotExecutor;
import org.hk.doghub.automation.e2e.selenium.ui.actions.pause.PauseExecutor;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Slf4j
public class DefaultTextInputExecutor implements TextInputExecutor {

    private final ElementRetriever elementRetriever;

    private final ElementHighlighter elementHighlighter;

    private final PauseExecutor pauseExecutor;

    private final ScreenshotExecutor screenshotExecutor;

    private final TextInputExecutorConfiguration textInputExecutorConfiguration;

    private final ElementKeysSender elementKeysSender;

    @Override
    public void enterText(@NotNull WebDriver webDriver, @NotNull By locator, @NotNull String text) {
        enterText(webDriver, locator, text, true, false);
    }

    @Override
    public void enterText(@NotNull WebDriver webDriver, @NotNull By locator, @NotNull String text, boolean enter, boolean oneByOne) {
        enterText(webDriver, elementRetriever.getByClickable(webDriver, locator), text, enter, oneByOne);
    }

    @Override
    public void enterText(@NotNull WebDriver webDriver, @NotNull WebElement element, @NotNull String text) {
        enterText(webDriver, element, text, true, false);
    }

    @Override
    public void enterText(@NotNull WebDriver webDriver, @NotNull WebElement element, @NotNull String text, boolean enter, boolean oneByOne) {
        log.info("Enter text '{}' to element started", text);
        elementHighlighter.eventHighlight(webDriver, element);
        element.clear();
        screenshotExecutor.execute(webDriver, textInputExecutorConfiguration.isTakeScreenshotBefore());
        pauseExecutor.pause();
        elementKeysSender.send(webDriver, element, text, oneByOne);
        screenshotExecutor.execute(webDriver, textInputExecutorConfiguration.isTakeScreenshotAfter());
        pauseExecutor.pause();
        if(enter) {
            element.sendKeys(Keys.ENTER);
        }
        log.info("Enter text '{}' to element completed", text);
    }
}
