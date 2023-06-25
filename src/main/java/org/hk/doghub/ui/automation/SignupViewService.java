package org.hk.doghub.ui.automation;

import jakarta.validation.constraints.NotNull;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.RandomStringUtils;
import org.hk.doghub.automation.e2e.selenium.element.retrieve.ElementRetriever;
import org.hk.doghub.automation.e2e.selenium.page.TitleVerifier;
import org.hk.doghub.automation.e2e.selenium.ui.actions.click.ClickExecutor;
import org.hk.doghub.automation.e2e.selenium.ui.actions.text.input.TextInputExecutor;
import org.hk.doghub.data.content.generator.user.UserProvider;
import org.hk.doghub.data.service.user.DogHubUserService;
import org.hk.doghub.ui.components.shared.EntityCreationButton;
import org.hk.doghub.ui.components.shared.user.UserEmailField;
import org.hk.doghub.ui.components.shared.user.UserPasswordField;
import org.hk.doghub.ui.views.site.login.LoginView;
import org.hk.doghub.ui.views.site.signup.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.springframework.stereotype.Service;

import static com.vaadin.flow.component.Tag.DIV;
import static com.vaadin.flow.component.Tag.INPUT;

@Service
@RequiredArgsConstructor
@Slf4j
public class SignupViewService {

    private final DogHubLandingPageService landingPageService;

    private final DogHubNavigator navigator;

    private final ClickExecutor clickExecutor;

    private final TextInputExecutor textInputExecutor;

    private final ElementRetriever elementRetriever;

    private final TitleVerifier titleVerifier;

    private final DogHubUserService userService;

    private final UserProvider userProvider;

    public void navigateFromHomePage(@NotNull WebDriver webDriver) {
        log.info("Navigate from home page started");
        landingPageService.clickSignup(webDriver);
        log.info("Navigate from home page completed");
    }

    public void navigateDirectly(@NotNull WebDriver webDriver) {
        log.info("Navigate directly started");
        navigator.navigateToSignupView(webDriver);
        titleVerifier.verifyEquals(webDriver, SignupView.NAME);
        log.info("Navigate directly completed");
    }

    public void clickSignupWithGoogle(@NotNull WebDriver webDriver) {
        log.info("Click signup with google started");
        clickExecutor.click(webDriver, By.className(SignupWithGoogle.CLASS_NAME));
        log.info("Click signup with google completed");
    }

    public void clickSignupWithFacebook(@NotNull WebDriver webDriver) {
        log.info("Click signup with facebook started");
        clickExecutor.click(webDriver, By.className(SignupWithFacebook.CLASS_NAME));
        log.info("Click signup with facebook completed");
    }

    public void enterEmail(@NotNull WebDriver webDriver, @NotNull String email) {
        log.info("Enter email {} started", email);
        WebElement emailFieldElement = elementRetriever.getByPresence(webDriver, By.className(UserEmailField.CLASS_NAME));
        WebElement emailFieldInputElement = emailFieldElement.findElement(By.tagName(INPUT));
        textInputExecutor.enterText(webDriver, emailFieldInputElement, email, true, true);
        log.info("Enter email {} completed", email);
    }

    public void enterPassword(@NotNull WebDriver webDriver, @NotNull String password) {
        log.info("Enter password {} started", password);
        WebElement passwordFieldElement = elementRetriever.getByPresence(webDriver, By.className(UserPasswordField.CLASS_NAME));
        WebElement passwordFieldInputElement = passwordFieldElement.findElement(By.tagName(INPUT));
        textInputExecutor.enterText(webDriver, passwordFieldInputElement, password, true, true);
        log.info("Enter password {} completed", password);
    }

    public void toggleShowHidePassword(@NotNull WebDriver webDriver) {
        log.info("Toggle show/hide password started");
        WebElement passwordFieldElement = elementRetriever.getByPresence(webDriver, By.className(UserPasswordField.CLASS_NAME));
        WebElement passwordFieldShowHideElement = passwordFieldElement.findElement(By.tagName("vaadin-password-field-button"));
        clickExecutor.click(webDriver, passwordFieldShowHideElement);
        log.info("Toggle show/hide password completed");
    }

    public void clickContinue(@NotNull WebDriver webDriver) {
        log.info("Click continue started");
        clickExecutor.click(webDriver, By.className(EntityCreationButton.CLASS_NAME));
        log.info("Click continue completed");
    }

    public void clickTermsOfService(@NotNull WebDriver webDriver) {
        log.info("Click terms of service started");
        clickExecutor.click(webDriver, By.className(TermsOfServiceAnchor.CLASS_NAME));
        log.info("Click terms of service completed");
    }

    public void clickPrivacyPolicy(@NotNull WebDriver webDriver) {
        log.info("Click privacy policy started");
        clickExecutor.click(webDriver, By.className(PrivacyPolicyAnchor.CLASS_NAME));
        log.info("Click privacy policy completed");
    }

    public void clickSignIn(@NotNull WebDriver webDriver) {
        log.info("Click sign in started");
        clickExecutor.click(webDriver, By.className(SignupFooterAlreadyHaveAccountLoginLink.CLASS_NAME));
        titleVerifier.verifyEquals(webDriver, LoginView.NAME);
        log.info("Click sign in completed");
    }

    public void verifySignup(@NotNull WebDriver webDriver, @NotNull String username) {
        log.info("Verify signup started");
        userService.existsByUsername(username);
        titleVerifier.verifyEquals(webDriver, LoginView.NAME);
        log.info("Verify signup completed");
    }

    public @NotNull String getValidEmail() {
        return userProvider.get().getEmail();
    }

    public @NotNull String getValidPassword() {
        return userProvider.get().getPassword();
    }

    public @NotNull String getInvalidEmail() {
        return RandomStringUtils.randomAlphabetic(12);
    }

    public void verifyEmailErrorMessage(@NotNull WebDriver webDriver) {
        log.info("Verify email error message started");
        WebElement emailFieldElement = elementRetriever.getByPresence(webDriver, By.className(UserEmailField.CLASS_NAME));
        WebElement emailFieldErrorMessageElement = emailFieldElement.findElement(By.tagName(DIV));
        assert emailFieldErrorMessageElement.getText().equals(UserEmailField.ERROR_MESSAGE);
        log.info("Verify email error message completed");
    }

    public @NotNull String getInvalidPassword() {
        return RandomStringUtils.randomAlphabetic(5);
    }

    public void verifyPasswordErrorMessage(@NotNull WebDriver webDriver) {
        log.info("Verify password error message started");
        WebElement passwordFieldElement = elementRetriever.getByPresence(webDriver, By.className(UserPasswordField.CLASS_NAME));
        WebElement passwordFieldErrorMessageElement = passwordFieldElement.findElement(By.tagName(DIV));
        assert passwordFieldErrorMessageElement.getText().equals(UserPasswordField.ERROR_MESSAGE);
        log.info("Verify password error message completed");
    }
}
