package org.hk.doghub.automation.e2e.selenium.ui.actions.popup;

import jakarta.validation.constraints.NotNull;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.hk.doghub.automation.e2e.selenium.element.display.status.ElementDisplayStatusRetriever;
import org.hk.doghub.automation.e2e.selenium.element.highlight.ElementHighlighter;
import org.hk.doghub.automation.e2e.selenium.element.retrieve.ElementRetriever;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.springframework.stereotype.Service;

@Service
@Slf4j
@RequiredArgsConstructor
public class DefaultPopupRemover implements PopupRemover {

    private final PopupRemoverConfiguration popupRemoverConfiguration;

    private final ElementDisplayStatusRetriever elementDisplayStatusRetriever;

    private final ElementRetriever elementRetriever;

    private final ElementHighlighter elementHighlighter;

    @Override
    public void remove(@NotNull WebDriver webDriver) {
        if(popupRemoverConfiguration.isEnabled()) {
            log.info("Popup remover execution started");
            By locator = By.xpath(popupRemoverConfiguration.getXpath());
            boolean displayed = elementDisplayStatusRetriever.isDisplayed(webDriver, locator);
            if(displayed) {
                log.info("Popup is displayed. Going to remove it");
                WebElement element = elementRetriever.getByClickable(webDriver, locator);
                elementHighlighter.eventHighlight(webDriver, element);
                element.click();
            }
            log.info("Popup remover execution completed");
        }
    }
}
