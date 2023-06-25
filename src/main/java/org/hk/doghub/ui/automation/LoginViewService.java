package org.hk.doghub.ui.automation;

import jakarta.validation.constraints.NotNull;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.hk.doghub.automation.e2e.selenium.element.retrieve.ElementRetriever;
import org.hk.doghub.automation.e2e.selenium.page.TitleVerifier;
import org.hk.doghub.automation.e2e.selenium.ui.actions.click.ClickExecutor;
import org.hk.doghub.automation.e2e.selenium.ui.actions.text.input.TextInputExecutor;
import org.hk.doghub.data.content.generator.user.UserProvider;
import org.hk.doghub.ui.views.site.login.LoginView;
import org.hk.doghub.ui.views.site.login.LoginWithFacebook;
import org.hk.doghub.ui.views.site.login.LoginWithGoogle;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.springframework.stereotype.Service;

import static com.vaadin.flow.component.Tag.DIV;
import static com.vaadin.flow.component.Tag.INPUT;

@Service
@RequiredArgsConstructor
@Slf4j
public class LoginViewService {

    private final DogHubLandingPageService landingPageService;

    private final DogHubNavigator navigator;

    private final ClickExecutor clickExecutor;

    private final TitleVerifier titleVerifier;

    private final TextInputExecutor textInputExecutor;

    private final ElementRetriever elementRetriever;

    private final UserProvider userProvider;

    public void navigateFromHomePage(@NotNull WebDriver webDriver) {
        log.info("Navigate from home page started");
        landingPageService.clickLogin(webDriver);
        log.info("Navigate from home page completed");
    }

    public void navigateDirectly(@NotNull WebDriver webDriver) {
        log.info("Navigate directly started");
        navigator.navigateToLoginView(webDriver);
        titleVerifier.verifyEquals(webDriver, LoginView.NAME);
        log.info("Navigate directly completed");
    }

    public void clickLoginWithGoogle(@NotNull WebDriver webDriver) {
        log.info("Click login with google started");
        clickExecutor.click(webDriver, By.className(LoginWithGoogle.CLASS_NAME));
        log.info("Click login with google completed");
    }

    public void clickLoginWithFacebook(@NotNull WebDriver webDriver) {
        log.info("Click login with facebook started");
        clickExecutor.click(webDriver, By.className(LoginWithFacebook.CLASS_NAME));
        log.info("Click login with facebook completed");
    }

    public void enterEmail(@NotNull WebDriver webDriver, @NotNull String email) {
        log.info("Enter email {} started", email);
        WebElement emailFieldElement = elementRetriever.getByPresence(webDriver, By.tagName("vaadin-text-field"));
        WebElement emailFieldInputElement = emailFieldElement.findElement(By.tagName(INPUT));
        textInputExecutor.enterText(webDriver, emailFieldInputElement, email, true, true);
        log.info("Enter email {} completed", email);
    }

    public void enterPassword(@NotNull WebDriver webDriver, @NotNull String password) {
        log.info("Enter password {} started", password);
        WebElement passwordFieldElement = elementRetriever.getByPresence(webDriver, By.tagName("vaadin-password-field"));
        WebElement passwordFieldInputElement = passwordFieldElement.findElement(By.tagName(INPUT));
        textInputExecutor.enterText(webDriver, passwordFieldInputElement, password, true, true);
        log.info("Enter password {} completed", password);
    }

    public void toggleShowHidePassword(@NotNull WebDriver webDriver) {
        log.info("Toggle show/hide password started");
        WebElement passwordFieldElement = elementRetriever.getByPresence(webDriver, By.tagName("vaadin-password-field"));
        WebElement passwordFieldShowHideElement = passwordFieldElement.findElement(By.tagName("vaadin-password-field-button"));
        clickExecutor.click(webDriver, passwordFieldShowHideElement);
        log.info("Toggle show/hide password completed");
    }

    public void verifyEmailErrorMessage(@NotNull WebDriver webDriver) {
        log.info("Verify email error message started");
        WebElement emailFieldElement = elementRetriever.getByPresence(webDriver, By.tagName("vaadin-text-field"));
        WebElement emailFieldErrorMessageElement = emailFieldElement.findElement(By.tagName(DIV));
        assert emailFieldErrorMessageElement.getText().equals("Username is required");
        log.info("Verify email error message completed");
    }

    public void verifyPasswordErrorMessage(@NotNull WebDriver webDriver) {
        log.info("Verify password error message started");
        WebElement passwordFieldElement = elementRetriever.getByPresence(webDriver, By.tagName("vaadin-password-field"));
        WebElement passwordFieldErrorMessageElement = passwordFieldElement.findElement(By.tagName(DIV));
        assert passwordFieldErrorMessageElement.getText().equals("Password is required");
        log.info("Verify password error message completed");
    }

    public void clickContinue(@NotNull WebDriver webDriver) {
        log.info("Click continue started");
        WebElement loginFormElement = elementRetriever.getByPresence(webDriver, By.tagName("form"));
        WebElement continueElement = loginFormElement.findElement(By.tagName("vaadin-button"));
        clickExecutor.click(webDriver, continueElement);
        log.info("Click continue completed");
    }

    public @NotNull String getValidEmail() {
        return userProvider.get().getEmail();
    }

    public @NotNull String getValidPassword() {
        return userProvider.get().getPassword();
    }
}
