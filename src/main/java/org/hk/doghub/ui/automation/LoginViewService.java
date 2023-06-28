package org.hk.doghub.ui.automation;

import jakarta.validation.constraints.NotNull;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.hk.doghub.automation.e2e.selenium.element.retrieve.ElementRetriever;
import org.hk.doghub.automation.e2e.selenium.page.TitleVerifier;
import org.hk.doghub.automation.e2e.selenium.ui.actions.click.ClickExecutor;
import org.hk.doghub.automation.e2e.selenium.ui.actions.text.input.TextInputExecutor;
import org.hk.doghub.data.content.generator.Provider;
import org.hk.doghub.data.content.generator.user.User;
import org.hk.doghub.data.content.provider.Converter;
import org.hk.doghub.data.service.EntityService;
import org.hk.doghub.model.user.DogHubUser;
import org.hk.doghub.model.user.Role;
import org.hk.doghub.ui.views.site.login.LoginFooterCreateAccountSignupLink;
import org.hk.doghub.ui.views.site.login.LoginView;
import org.hk.doghub.ui.views.site.login.LoginWithFacebook;
import org.hk.doghub.ui.views.site.login.LoginWithGoogle;
import org.hk.doghub.ui.views.site.profile.ProfileView;
import org.hk.doghub.ui.views.site.signup.SignupView;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.springframework.stereotype.Service;

import java.util.Set;

import static com.vaadin.flow.component.Tag.*;
import static org.hk.doghub.model.user.Role.ADMIN;
import static org.hk.doghub.model.user.Role.USER;

@Service
@RequiredArgsConstructor
@Slf4j
public class LoginViewService {

    private final SiteHomeViewService siteHomeViewService;

    private final DogHubNavigator navigator;

    private final ClickExecutor clickExecutor;

    private final TitleVerifier titleVerifier;

    private final TextInputExecutor textInputExecutor;

    private final ElementRetriever elementRetriever;

    private final Provider<User> userProvider;

    private final Converter<User, DogHubUser> userConverter;

    private final EntityService<DogHubUser> userEntityService;

    public void navigateFromHomePage(@NotNull WebDriver webDriver) {
        siteHomeViewService.clickLogin(webDriver);
    }

    public void navigateDirectly(@NotNull WebDriver webDriver) {
        navigator.navigateToLoginView(webDriver);
        titleVerifier.verifyEquals(webDriver, LoginView.NAME);
    }

    public void clickLoginWithGoogle(@NotNull WebDriver webDriver) {
        clickExecutor.click(webDriver, By.className(LoginWithGoogle.CLASS_NAME));
    }

    public void clickLoginWithFacebook(@NotNull WebDriver webDriver) {
        clickExecutor.click(webDriver, By.className(LoginWithFacebook.CLASS_NAME));
    }

    public void enterEmail(@NotNull WebDriver webDriver, @NotNull String email) {
        WebElement emailFieldElement = elementRetriever.getByPresence(webDriver, By.tagName("vaadin-text-field"));
        WebElement emailFieldInputElement = emailFieldElement.findElement(By.tagName(INPUT));
        textInputExecutor.enterText(webDriver, emailFieldInputElement, email, true, true);
    }

    public void enterPassword(@NotNull WebDriver webDriver, @NotNull String password) {
        WebElement passwordFieldElement = elementRetriever.getByPresence(webDriver, By.tagName("vaadin-password-field"));
        WebElement passwordFieldInputElement = passwordFieldElement.findElement(By.tagName(INPUT));
        textInputExecutor.enterText(webDriver, passwordFieldInputElement, password, true, true);
    }

    public void toggleShowHidePassword(@NotNull WebDriver webDriver) {
        WebElement passwordFieldElement = elementRetriever.getByPresence(webDriver, By.tagName("vaadin-password-field"));
        WebElement passwordFieldShowHideElement = passwordFieldElement.findElement(By.tagName("vaadin-password-field-button"));
        clickExecutor.click(webDriver, passwordFieldShowHideElement);
    }

    public void verifyEmailErrorMessage(@NotNull WebDriver webDriver) {
        WebElement emailFieldElement = elementRetriever.getByPresence(webDriver, By.tagName("vaadin-text-field"));
        WebElement emailFieldErrorMessageElement = emailFieldElement.findElement(By.tagName(DIV));
        assert emailFieldErrorMessageElement.getText().equals("Username is required");
    }

    public void verifyPasswordErrorMessage(@NotNull WebDriver webDriver) {
        WebElement passwordFieldElement = elementRetriever.getByPresence(webDriver, By.tagName("vaadin-password-field"));
        WebElement passwordFieldErrorMessageElement = passwordFieldElement.findElement(By.tagName(DIV));
        assert passwordFieldErrorMessageElement.getText().equals("Password is required");
    }

    public void clickContinue(@NotNull WebDriver webDriver) {
        WebElement loginFormElement = elementRetriever.getByPresence(webDriver, By.tagName("form"));
        WebElement continueElement = loginFormElement.findElement(By.tagName("vaadin-button"));
        clickExecutor.click(webDriver, continueElement);
    }
    public void clickSignup(@NotNull WebDriver webDriver) {
        clickExecutor.click(webDriver, By.className(LoginFooterCreateAccountSignupLink.CLASS_NAME));
        titleVerifier.verifyEquals(webDriver, SignupView.NAME);
    }

    public @NotNull String getValidEmail() {
        return userProvider.get().getEmail();
    }

    public @NotNull String getValidPassword() {
        return userProvider.get().getPassword();
    }

    public void verifyIncorrectUsernameOrPasswordMessage(@NotNull WebDriver webDriver) {
        WebElement loginFormWrapperElement = elementRetriever.getByPresence(webDriver, By.tagName("vaadin-login-form-wrapper"));
        WebElement formSectionElement = loginFormWrapperElement.getShadowRoot().findElement(By.cssSelector(SECTION));
        WebElement errorMessageElement = formSectionElement.findElement(By.tagName(DIV));
        WebElement errorMessageTitleElement = errorMessageElement.findElement(By.tagName(H5));
        assert errorMessageTitleElement.getText().equals("Incorrect username or password");
    }

    public void verifyLoggedIn(@NotNull WebDriver webDriver) {
        assert siteHomeViewService.isLoggedIn(webDriver);
    }

    public void verifyLoggedInWithSignedUpUser(@NotNull WebDriver webDriver) {
        titleVerifier.verifyEquals(webDriver, ProfileView.NAME);
    }

    public User loadUser() {
        return loadUser(Set.of(USER));
    }

    public User loadUserWithAdminRole() {
        return loadUser(Set.of(ADMIN));
    }

    public User loadUserWithAdminAndUserRoles() {
        return loadUser(Set.of(ADMIN, USER));
    }

    private User loadUser(Set<Role> roles) {
        User user = userProvider.get();
        DogHubUser dogHubUser = userConverter.convert(user);
        dogHubUser.setRoles(roles);
        userEntityService.save(dogHubUser);
        return user;
    }
}
