package org.hk.doghub.automation.e2e.selenium.mapping.provider;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.openqa.selenium.By;
import org.springframework.stereotype.Service;

@Service
@Slf4j
@RequiredArgsConstructor
public class SignupLoginElementLocatorProvider {

    public By getNewUserSignupHeader() {
        return By.xpath("//div[@class='signup-form']/child::h2");
    }

    public By getSignupNameInput() {
        return By.xpath("//form/child::input[@data-qa='signup-name']");
    }

    public By getSignupEmailAddressInput() {
        return By.xpath("//form/child::input[@data-qa='signup-email']");
    }

    public By getSignupButton() {
        return By.xpath("//button[@data-qa='signup-button']");
    }

    public By getLoginButton() {
        return By.xpath("//button[@data-qa='login-button']");
    }

    public By getLoginHeader() {
        return By.xpath("//div[@class='login-form']/child::h2");
    }

    public By getLoginEmailAddressInput() {
        return By.xpath("//form/child::input[@data-qa='login-email']");
    }

    public By getLoginPasswordInput() {
        return By.xpath("//form/child::input[@data-qa='login-password']");
    }

    public By getInvalidLoginCredentialsMessage() {
        return By.xpath("//input[@data-qa='login-email']/parent::form/child::p");
    }

    public By getExistingEmailAddressMessage() {
        return By.xpath("//input[@data-qa='signup-email']/parent::form/child::p");
    }
}
