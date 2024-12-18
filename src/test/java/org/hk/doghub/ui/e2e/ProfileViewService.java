package org.hk.doghub.ui.e2e;

import jakarta.validation.constraints.NotNull;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.RandomStringUtils;
import org.hk.doghub.automation.e2e.selenium.element.display.status.ElementDisplayStatusRetriever;
import org.hk.doghub.automation.e2e.selenium.element.highlight.ElementHighlighter;
import org.hk.doghub.automation.e2e.selenium.element.retrieve.ElementRetriever;
import org.hk.doghub.automation.e2e.selenium.ui.actions.click.ClickExecutor;
import org.hk.doghub.automation.e2e.selenium.ui.actions.text.input.TextInputExecutor;
import org.hk.doghub.data.content.generator.user.UserProvider;
import org.hk.doghub.ui.components.shared.InfoCancelButton;
import org.hk.doghub.ui.components.shared.InfoSaveButton;
import org.hk.doghub.ui.components.shared.SaveFailedWithInvalidInputNotification;
import org.hk.doghub.ui.components.shared.SavedSuccessfullyNotification;
import org.hk.doghub.ui.components.shared.user.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import static com.vaadin.flow.component.Tag.INPUT;
import static org.hk.doghub.model.user.DogHubUser.TITLE_MAX_LENGTH;

@Service
@RequiredArgsConstructor
@Slf4j
public class ProfileViewService {

    private final UserMenuBarService userMenuBarService;

    private final ElementDisplayStatusRetriever elementDisplayStatusRetriever;

    private final ElementRetriever elementRetriever;

    private final ElementHighlighter elementHighlighter;

    private final ClickExecutor clickExecutor;

    private final TextInputExecutor textInputExecutor;

    private final UserProvider userProvider;

    public void navigateFromHomePage(@NotNull WebDriver webDriver) {
        userMenuBarService.navigateToProfileView(webDriver);
    }

    public void verifyIdDisplayed(@NotNull WebDriver webDriver) {
        verifyFieldDisplayed(webDriver, By.className(UserIdField.CLASS_NAME));
    }

    public String getIdValue(@NotNull WebDriver webDriver) {
        return getTextFieldValue(webDriver, By.className(UserIdField.CLASS_NAME));
    }

    public void verifyIdReadOnly(@NotNull WebDriver webDriver) {
        verifyFieldReadOnly(webDriver, By.className(UserIdField.CLASS_NAME));
    }

    public void verifyUsernameDisplayed(@NotNull WebDriver webDriver) {
        verifyFieldDisplayed(webDriver, By.className(UserUsernameField.CLASS_NAME));
    }

    public void verifyUsernameReadOnly(@NotNull WebDriver webDriver) {
        verifyFieldReadOnly(webDriver, By.className(UserUsernameField.CLASS_NAME));
    }

    public String getUsernameValue(@NotNull WebDriver webDriver) {
        return getTextFieldValue(webDriver, By.className(UserUsernameField.CLASS_NAME));
    }

    public void verifyTitleDisplayed(@NotNull WebDriver webDriver) {
        verifyFieldDisplayed(webDriver, By.className(UserTitleField.CLASS_NAME));
    }

    public String getTitleValue(@NotNull WebDriver webDriver) {
        return getTextFieldValue(webDriver, By.className(UserTitleField.CLASS_NAME));
    }

    public void enterTitle(@NotNull WebDriver webDriver) {
        enterValueToTextField(webDriver, By.className(UserTitleField.CLASS_NAME), userProvider.get().getTitle());
    }

    public void enterInvalidTitle(@NotNull WebDriver webDriver) {
        enterValueToTextField(webDriver, By.className(UserTitleField.CLASS_NAME), RandomStringUtils.randomAlphabetic(TITLE_MAX_LENGTH+10));
    }

    public void verifyNameDisplayed(@NotNull WebDriver webDriver) {
        verifyFieldDisplayed(webDriver, By.className(UserNameField.CLASS_NAME));
    }

    public String getNameValue(@NotNull WebDriver webDriver) {
        return getTextFieldValue(webDriver, By.className(UserNameField.CLASS_NAME));
    }

    public void enterName(@NotNull WebDriver webDriver) {
        enterValueToTextField(webDriver, By.className(UserNameField.CLASS_NAME), userProvider.get().getName());
    }

    public void verifyMobileNumberDisplayed(@NotNull WebDriver webDriver) {
        verifyFieldDisplayed(webDriver, By.className(UserMobileNumberField.CLASS_NAME));
    }

    public String getMobileNumberValue(@NotNull WebDriver webDriver) {
        return getTextFieldValue(webDriver, By.className(UserMobileNumberField.CLASS_NAME));
    }

    public void enterMobileNumber(@NotNull WebDriver webDriver) {
        enterValueToTextField(webDriver, By.className(UserMobileNumberField.CLASS_NAME), userProvider.get().getMobileNumber());
    }

    public void verifyEmailDisplayed(@NotNull WebDriver webDriver) {
        verifyFieldDisplayed(webDriver, By.className(UserEmailField.CLASS_NAME));
    }

    public String getEmailValue(@NotNull WebDriver webDriver) {
        return getTextFieldValue(webDriver, By.className(UserEmailField.CLASS_NAME));
    }

    public void enterEmail(@NotNull WebDriver webDriver) {
        enterValueToTextField(webDriver, By.className(UserEmailField.CLASS_NAME), userProvider.get().getEmail());
    }

    public void verifyThumbnailPictureDisplayed(@NotNull WebDriver webDriver) {
        verifyFieldDisplayed(webDriver, By.className(UserThumbnailPictureField.CLASS_NAME));
    }

    public String getThumbnailPictureValue(@NotNull WebDriver webDriver) {
        return getTextFieldValue(webDriver, By.className(UserThumbnailPictureField.CLASS_NAME));
    }

    public void enterThumbnailPicture(@NotNull WebDriver webDriver) {
        enterValueToTextField(webDriver, By.className(UserThumbnailPictureField.CLASS_NAME), userProvider.get().getThumbnailPicture());
    }

    public void verifyCompanyDisplayed(@NotNull WebDriver webDriver) {
        verifyFieldDisplayed(webDriver, By.className(UserCompanyField.CLASS_NAME));
    }

    public String getCompanyValue(@NotNull WebDriver webDriver) {
        return getTextFieldValue(webDriver, By.className(UserCompanyField.CLASS_NAME));
    }

    public void enterCompany(@NotNull WebDriver webDriver) {
        enterValueToTextField(webDriver, By.className(UserCompanyField.CLASS_NAME), userProvider.get().getCompany());
    }

    public void verifyDateOfBirthDisplayed(@NotNull WebDriver webDriver) {
        verifyFieldDisplayed(webDriver, By.className(UserDateOfBirthField.CLASS_NAME));
    }

    public LocalDateTime getDateOfBirthValue(@NotNull WebDriver webDriver) {
        return getDateTimeFieldValue(webDriver, By.className(UserDateOfBirthField.CLASS_NAME));
    }

    public void enterDateOfBirth(@NotNull WebDriver webDriver) {
        enterValueToDateTimeField(webDriver, By.className(UserDateOfBirthField.CLASS_NAME), userProvider.get().getDateOfBirth().toLocalDateTime());
    }

    public void verifyDateOfRegistrationDisplayed(@NotNull WebDriver webDriver) {
        verifyFieldDisplayed(webDriver, By.className(UserDateOfRegistrationField.CLASS_NAME));
    }

    public LocalDateTime getDateOfRegistrationValue(@NotNull WebDriver webDriver) {
        return getDateTimeFieldValue(webDriver, By.className(UserDateOfRegistrationField.CLASS_NAME));
    }

    public void verifyDateOfRegistrationReadOnly(@NotNull WebDriver webDriver) {
        verifyFieldReadOnly(webDriver, By.className(UserDateOfRegistrationField.CLASS_NAME));
    }

    public void verifyCountryDisplayed(@NotNull WebDriver webDriver) {
        verifyFieldDisplayed(webDriver, By.className(UserCountryField.CLASS_NAME));
    }

    public String getCountryValue(@NotNull WebDriver webDriver) {
        return getTextFieldValue(webDriver, By.className(UserCountryField.CLASS_NAME));
    }

    public void enterCountry(@NotNull WebDriver webDriver) {
        enterValueToTextField(webDriver, By.className(UserCountryField.CLASS_NAME), userProvider.get().getAddress().getCountry());
    }

    public void verifyStateDisplayed(@NotNull WebDriver webDriver) {
        verifyFieldDisplayed(webDriver, By.className(UserStateField.CLASS_NAME));
    }

    public String getStateValue(@NotNull WebDriver webDriver) {
        return getTextFieldValue(webDriver, By.className(UserStateField.CLASS_NAME));
    }

    public void enterState(@NotNull WebDriver webDriver) {
        enterValueToTextField(webDriver, By.className(UserStateField.CLASS_NAME), userProvider.get().getAddress().getState());
    }

    public void verifyCityDisplayed(@NotNull WebDriver webDriver) {
        verifyFieldDisplayed(webDriver, By.className(UserCityField.CLASS_NAME));
    }

    public String getCityValue(@NotNull WebDriver webDriver) {
        return getTextFieldValue(webDriver, By.className(UserCityField.CLASS_NAME));
    }

    public void enterCity(@NotNull WebDriver webDriver) {
        enterValueToTextField(webDriver, By.className(UserCityField.CLASS_NAME), userProvider.get().getAddress().getCity());
    }

    public void verifyStreetNameDisplayed(@NotNull WebDriver webDriver) {
        verifyFieldDisplayed(webDriver, By.className(UserStreetNameField.CLASS_NAME));
    }

    public String getStreetNameValue(@NotNull WebDriver webDriver) {
        return getTextFieldValue(webDriver, By.className(UserStreetNameField.CLASS_NAME));
    }

    public void enterStreetName(@NotNull WebDriver webDriver) {
        enterValueToTextField(webDriver, By.className(UserStreetNameField.CLASS_NAME), userProvider.get().getAddress().getStreetName());
    }

    public void verifyStreetNumberDisplayed(@NotNull WebDriver webDriver) {
        verifyFieldDisplayed(webDriver, By.className(UserStreetNumberField.CLASS_NAME));
    }

    public String getStreetNumberValue(@NotNull WebDriver webDriver) {
        return getTextFieldValue(webDriver, By.className(UserStreetNumberField.CLASS_NAME));
    }

    public void enterStreetNumber(@NotNull WebDriver webDriver) {
        enterValueToTextField(webDriver, By.className(UserStreetNumberField.CLASS_NAME), String.valueOf(userProvider.get().getAddress().getNumber()));
    }

    public void verifyPostcodeDisplayed(@NotNull WebDriver webDriver) {
        verifyFieldDisplayed(webDriver, By.className(UserPostcodeField.CLASS_NAME));
    }

    public String getPostcodeValue(@NotNull WebDriver webDriver) {
        return getTextFieldValue(webDriver, By.className(UserPostcodeField.CLASS_NAME));
    }

    public void enterPostcode(@NotNull WebDriver webDriver) {
        enterValueToTextField(webDriver, By.className(UserPostcodeField.CLASS_NAME), userProvider.get().getAddress().getPostcode());
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

    public void verifySaveFailedWithInvalidInputNotificationDisplayed(@NotNull WebDriver webDriver) {
        elementRetriever.getByPresence(webDriver, By.className(SaveFailedWithInvalidInputNotification.CLASS_NAME));
    }

    private void verifyFieldDisplayed(@NotNull WebDriver webDriver, @NotNull By fieldLocator) {
        assert elementDisplayStatusRetriever.isDisplayed(webDriver, fieldLocator);
    }

    private String getTextFieldValue(@NotNull WebDriver webDriver, @NotNull By fieldLocator) {
        WebElement inputElement = elementRetriever.getByPresence(webDriver, fieldLocator).findElement(By.tagName(INPUT));
        elementHighlighter.highlight(webDriver, inputElement);
        String value = inputElement.getAttribute("value");
        log.info("Field value is: {}", value);
        return value;
    }

    private LocalDateTime getDateTimeFieldValue(@NotNull WebDriver webDriver, @NotNull By fieldLocator) {
        WebElement datePickerElement = elementRetriever.getByPresence(webDriver, fieldLocator).findElement(By.tagName("vaadin-date-picker"));
        WebElement datePickerInputElement = datePickerElement.findElement(By.tagName(INPUT));
        elementHighlighter.highlight(webDriver, datePickerInputElement);
        String dateValue = datePickerInputElement.getAttribute("value");

        WebElement timePickerElement = elementRetriever.getByPresence(webDriver, fieldLocator).findElement(By.tagName("vaadin-time-picker"));
        WebElement timePickerInputElement = timePickerElement.findElement(By.tagName(INPUT));
        elementHighlighter.highlight(webDriver, timePickerInputElement);
        String timeValue = timePickerInputElement.getAttribute("value");

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy H:mm");
        return LocalDateTime.parse(dateValue + " " + timeValue, formatter);
    }

    private void verifyFieldReadOnly(@NotNull WebDriver webDriver, @NotNull By fieldLocator) {
        assert elementRetriever.getByPresence(webDriver, fieldLocator).getAttribute("readonly").equalsIgnoreCase(Boolean.TRUE.toString());
    }

    private void enterValueToTextField(@NotNull WebDriver webDriver, @NotNull By fieldLocator, @NotNull String value) {
        WebElement inputElement = elementRetriever.getByPresence(webDriver, fieldLocator).findElement(By.tagName(INPUT));
        textInputExecutor.enterText(webDriver, inputElement, value, true, true);
    }

    private void enterValueToDateTimeField(@NotNull WebDriver webDriver, @NotNull By fieldLocator, @NotNull LocalDateTime localDateTime) {
        WebElement datePickerElement = elementRetriever.getByPresence(webDriver, fieldLocator).findElement(By.tagName("vaadin-date-picker"));
        WebElement datePickerInputElement = datePickerElement.findElement(By.tagName(INPUT));
        textInputExecutor.enterText(webDriver, datePickerInputElement, localDateTime.format(DateTimeFormatter.ofPattern("dd/MM/yyyy")), true, true);

        WebElement timePickerElement = elementRetriever.getByPresence(webDriver, fieldLocator).findElement(By.tagName("vaadin-time-picker"));
        WebElement timePickerInputElement = timePickerElement.findElement(By.tagName(INPUT));
        textInputExecutor.enterText(webDriver, timePickerInputElement, localDateTime.format(DateTimeFormatter.ofPattern("HH:mm")), true, true);
    }
}
