package org.hk.doghub.ui.automation;

import jakarta.validation.constraints.NotNull;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.hk.doghub.automation.e2e.selenium.element.display.status.ElementDisplayStatusRetriever;
import org.hk.doghub.automation.e2e.selenium.element.highlight.ElementHighlighter;
import org.hk.doghub.automation.e2e.selenium.element.retrieve.ElementRetriever;
import org.hk.doghub.ui.components.shared.user.UserIdField;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.springframework.stereotype.Service;

import static com.vaadin.flow.component.Tag.INPUT;
import static java.text.MessageFormat.format;

@Service
@RequiredArgsConstructor
@Slf4j
public class ProfileViewService {

    private final UserMenuBarService userMenuBarService;

    private final ElementDisplayStatusRetriever elementDisplayStatusRetriever;

    private final ElementRetriever elementRetriever;

    private final ElementHighlighter elementHighlighter;

    public void navigateFromHomePage(@NotNull WebDriver webDriver) {
        userMenuBarService.navigateToProfileView(webDriver);
    }

    public void verifyIdDisplayed(@NotNull WebDriver webDriver) {
        By fieldLocator = By.className(UserIdField.CLASS_NAME);
        assert elementDisplayStatusRetriever.isDisplayed(webDriver, fieldLocator);
        WebElement inputElement = elementRetriever.getByPresence(webDriver, fieldLocator).findElement(By.tagName(INPUT));
        elementHighlighter.highlight(webDriver, inputElement);
        String value = inputElement.getAttribute("value");
        log.info(format("Field value is: {0}", value));
    }
}
