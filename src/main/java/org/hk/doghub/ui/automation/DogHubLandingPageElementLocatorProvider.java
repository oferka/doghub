package org.hk.doghub.ui.automation;

import jakarta.validation.constraints.NotNull;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.openqa.selenium.By;
import org.springframework.stereotype.Service;

import static java.lang.String.format;

@Service
@Slf4j
@RequiredArgsConstructor
public class DogHubLandingPageElementLocatorProvider {

    public @NotNull By getSignupLoginLink() {
        return By.xpath("//i[@class='fa fa-lock']/parent::a");
    }

    public By getDeleteAccountButton() {
        return By.xpath("//i[@class='fa fa-trash-o']/parent::a");
    }

    public By getAccountDeletedHeader() {
        return By.xpath("//h2[@data-qa='account-deleted']");
    }

    public By getContinueButton() {
        return By.xpath("//a[@data-qa='continue-button']");
    }

    public By getLogoutLink() {
        return By.xpath("//i[@class='fa fa-lock']/parent::a");
    }

    public By getContactUsLink() {
        return By.xpath("//i[@class='fa fa-envelope']/parent::a");
    }

    public By getSubscriptionInput() {
        return By.xpath("//input[@id='susbscribe_email']");
    }

    public By getCopyright() {
        return By.xpath("//p[@class='pull-left']");
    }

    public By getTestCasesLink() {
        return By.xpath("//i[@class='fa fa-list']/parent::a[@href='/test_cases']");
    }

    public By getHomeLink() {
        return By.xpath("//i[@class='fa fa-home']/parent::a");
    }

    public By getLogo() {
        return By.xpath("//div[@class='logo pull-left']");
    }

    public By getCartLink() {
        return By.xpath("//i[@class='fa fa-shopping-cart']/parent::a");
    }

    public By getApiTestingLink() {
        return By.xpath("//i[@class='fa fa-list']/parent::a[@href='/api_list']");
    }

    public By getNavigationBarLinks() {
        return By.xpath("//ul[@class='nav navbar-nav']/li/a");
    }

    public By getNavigationBarLink(int index) {
        return By.xpath(format("//ul[@class='nav navbar-nav']/li[%s]/a", index));
    }
}
