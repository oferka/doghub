package org.hk.doghub.ui.automation;

import jakarta.validation.constraints.NotNull;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.hk.doghub.automation.e2e.selenium.element.retrieve.ElementRetriever;
import org.hk.doghub.automation.e2e.selenium.ui.actions.click.ClickExecutor;
import org.hk.doghub.automation.e2e.selenium.ui.actions.text.input.TextInputExecutor;
import org.hk.doghub.ui.components.shared.user.UserEmailField;
import org.hk.doghub.ui.views.site.signup.SignupWithFacebook;
import org.hk.doghub.ui.views.site.signup.SignupWithGoogle;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.springframework.stereotype.Service;

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

    public void navigateFromHomePage(@NotNull WebDriver webDriver) {
        log.info("Navigate from home page started");
        landingPageService.clickSignup(webDriver);
        log.info("Navigate from home page completed");
    }

    public void navigateDirectly(@NotNull WebDriver webDriver) {
        log.info("Navigate directly started");
        navigator.navigateToSignupView(webDriver);
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
}
