package org.hk.doghub.ui.automation;

import jakarta.validation.constraints.NotNull;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.hk.doghub.automation.e2e.selenium.element.display.status.ElementDisplayStatusRetriever;
import org.hk.doghub.automation.e2e.selenium.element.highlight.ElementHighlighter;
import org.hk.doghub.automation.e2e.selenium.element.retrieve.ElementRetriever;
import org.hk.doghub.automation.e2e.selenium.ui.actions.click.ClickExecutor;
import org.hk.doghub.automation.e2e.selenium.ui.actions.pause.PauseExecutor;
import org.hk.doghub.automation.e2e.selenium.ui.actions.text.input.TextInputExecutor;
import org.hk.doghub.data.content.generator.user.UserProvider;
import org.hk.doghub.ui.components.shared.InfoCancelButton;
import org.hk.doghub.ui.components.shared.InfoSaveButton;
import org.hk.doghub.ui.components.shared.SavedSuccessfullyNotification;
import org.hk.doghub.ui.components.shared.user.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.springframework.stereotype.Service;

import java.time.Duration;

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

    private final PauseExecutor pauseExecutor;

    private final ClickExecutor clickExecutor;

    private final TextInputExecutor textInputExecutor;

    private final UserProvider userProvider;

    public void navigateFromHomePage(@NotNull WebDriver webDriver) {
        userMenuBarService.navigateToProfileView(webDriver);
    }

    public void verifyIdDisplayed(@NotNull WebDriver webDriver) {
        verifyFieldDisplayed(webDriver, By.className(UserIdField.CLASS_NAME));
    }

    public void verifyUsernameDisplayed(@NotNull WebDriver webDriver) {
        verifyFieldDisplayed(webDriver, By.className(UserUsernameField.CLASS_NAME));
    }

    public void verifyTitleDisplayed(@NotNull WebDriver webDriver) {
        verifyFieldDisplayed(webDriver, By.className(UserTitleField.CLASS_NAME));
    }

    public void verifyNameDisplayed(@NotNull WebDriver webDriver) {
        verifyFieldDisplayed(webDriver, By.className(UserNameField.CLASS_NAME));
    }

    public void verifyMobileNumberDisplayed(@NotNull WebDriver webDriver) {
        verifyFieldDisplayed(webDriver, By.className(UserMobileNumberField.CLASS_NAME));
    }

    public void verifyEmailDisplayed(@NotNull WebDriver webDriver) {
        verifyFieldDisplayed(webDriver, By.className(UserEmailField.CLASS_NAME));
    }

    public void verifyThumbnailPictureDisplayed(@NotNull WebDriver webDriver) {
        verifyFieldDisplayed(webDriver, By.className(UserThumbnailPictureField.CLASS_NAME));
    }

    public void verifyCompanyDisplayed(@NotNull WebDriver webDriver) {
        verifyFieldDisplayed(webDriver, By.className(UserCompanyField.CLASS_NAME));
    }

    public void verifyDateOfBirthDisplayed(@NotNull WebDriver webDriver) {
        verifyFieldDisplayed(webDriver, By.className(UserDateOfBirthField.CLASS_NAME));
    }

    public void verifyDateOfRegistrationDisplayed(@NotNull WebDriver webDriver) {
        verifyFieldDisplayed(webDriver, By.className(UserDateOfRegistrationField.CLASS_NAME));
    }

    public void verifyCountryDisplayed(@NotNull WebDriver webDriver) {
        verifyFieldDisplayed(webDriver, By.className(UserCountryField.CLASS_NAME));
    }

    public void verifyStateDisplayed(@NotNull WebDriver webDriver) {
        verifyFieldDisplayed(webDriver, By.className(UserStateField.CLASS_NAME));
    }

    public void verifyCityDisplayed(@NotNull WebDriver webDriver) {
        verifyFieldDisplayed(webDriver, By.className(UserCityField.CLASS_NAME));
    }

    public void verifyStreetNameDisplayed(@NotNull WebDriver webDriver) {
        verifyFieldDisplayed(webDriver, By.className(UserStreetNameField.CLASS_NAME));
    }

    public void verifyStreetNumberDisplayed(@NotNull WebDriver webDriver) {
        verifyFieldDisplayed(webDriver, By.className(UserStreetNumberField.CLASS_NAME));
    }

    public void verifyPostcodeDisplayed(@NotNull WebDriver webDriver) {
        verifyFieldDisplayed(webDriver, By.className(UserPostcodeField.CLASS_NAME));
    }

    private void verifyFieldDisplayed(@NotNull WebDriver webDriver, By fieldLocator) {
        assert elementDisplayStatusRetriever.isDisplayed(webDriver, fieldLocator);
        WebElement inputElement = elementRetriever.getByPresence(webDriver, fieldLocator).findElement(By.tagName(INPUT));
        elementHighlighter.highlight(webDriver, inputElement);
        String value = inputElement.getAttribute("value");
        log.info(format("Field value is: {0}", value));
        pauseExecutor.pause(Duration.ofSeconds(1));
    }

    public void clickSave(@NotNull WebDriver webDriver) {
        clickExecutor.click(webDriver, By.className(InfoSaveButton.CLASS_NAME));
    }

    public void clickCancel(@NotNull WebDriver webDriver) {
        clickExecutor.click(webDriver, By.className(InfoCancelButton.CLASS_NAME));
    }

    public void verifySavedSuccessfullyNotificationDisplayed(@NotNull WebDriver webDriver) {
        elementRetriever.getByPresence(webDriver, By.className(SavedSuccessfullyNotification.CLASS_NAME));
    }

    public void enterName(@NotNull WebDriver webDriver) {
        enterValueToField(webDriver, By.className(UserNameField.CLASS_NAME), userProvider.get().getName());
    }

    public void enterMobileNumber(@NotNull WebDriver webDriver) {
        enterValueToField(webDriver, By.className(UserMobileNumberField.CLASS_NAME), userProvider.get().getMobileNumber());
    }

    public void enterEmail(@NotNull WebDriver webDriver) {
        enterValueToField(webDriver, By.className(UserEmailField.CLASS_NAME), userProvider.get().getEmail());
    }

    private void enterValueToField(@NotNull WebDriver webDriver, @NotNull By fieldLocator, @NotNull String value) {
        WebElement inputElement = elementRetriever.getByPresence(webDriver, fieldLocator).findElement(By.tagName(INPUT));
        textInputExecutor.enterText(webDriver, inputElement, value, true, true);
    }
}
