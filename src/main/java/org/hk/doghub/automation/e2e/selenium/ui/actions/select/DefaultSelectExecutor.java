package org.hk.doghub.automation.e2e.selenium.ui.actions.select;

import jakarta.validation.constraints.NotBlank;
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
import org.openqa.selenium.support.ui.Select;
import org.springframework.stereotype.Service;

import java.util.List;

import static org.apache.commons.lang3.RandomUtils.nextInt;

@Service
@Slf4j
@RequiredArgsConstructor
public class DefaultSelectExecutor implements SelectExecutor {

    private final ElementRetriever elementRetriever;

    private final ElementHighlighter elementHighlighter;

    private final PauseExecutor pauseExecutor;

    private final ScreenshotExecutor screenshotExecutor;

    private final SelectExecutorConfiguration selectExecutorConfiguration;

    private final PopupRemover popupRemover;

    private final SelectSoundPlayer selectSoundPlayer;

    @Override
    public void selectByVisibleText(@NotNull WebDriver webDriver, @NotNull By locator, @NotNull @NotBlank String text) {
        log.info("Select by visible text '{}' started", text);
        WebElement element = beforeElementAction(webDriver, locator);
        Select selectElement = new Select(element);
        selectElement.selectByVisibleText(text);
        pauseExecutor.pause();
        log.info("Select by visible text '{}' completed", text);
    }

    @Override
    public void selectByValue(@NotNull WebDriver webDriver, @NotNull By locator, @NotNull @NotBlank String value) {
        log.info("Select by value '{}' started", value);
        WebElement element = beforeElementAction(webDriver, locator);
        Select selectElement = new Select(element);
        selectElement.selectByValue(value);
        pauseExecutor.pause();
        log.info("Select by value '{}' completed", value);
    }

    @Override
    public void selectByIndex(@NotNull WebDriver webDriver, @NotNull By locator, int index) {
        log.info("Select by index '{}' started", index);
        WebElement element = beforeElementAction(webDriver, locator);
        Select selectElement = new Select(element);
        selectElement.selectByIndex(index);
        pauseExecutor.pause();
        log.info("Select by index '{}' completed", index);
    }

    @Override
    public void selectRandom(@NotNull WebDriver webDriver, @NotNull By locator) {
        log.info("Select random started");
        WebElement element = beforeElementAction(webDriver, locator);
        Select selectElement = new Select(element);
        List<WebElement> options = selectElement.getOptions();
        int randomIndex = nextInt(0, options.size());
        selectElement.selectByIndex(randomIndex);
        pauseExecutor.pause();
        log.info("Select random completed. Selected option text is '{}'", options.get(randomIndex).getText());
    }

    private WebElement beforeElementAction(@NotNull WebDriver webDriver, @NotNull By locator) {
        WebElement element = elementRetriever.getByClickable(webDriver, locator);
        elementHighlighter.eventHighlight(webDriver, element);
        screenshotExecutor.execute(webDriver, selectExecutorConfiguration.isTakeScreenshot());
        popupRemover.remove(webDriver);
        selectSoundPlayer.play();
        return element;
    }
}
