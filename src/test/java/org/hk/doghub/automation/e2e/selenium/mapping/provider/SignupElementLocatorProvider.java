package org.hk.doghub.automation.e2e.selenium.mapping.provider;

import jakarta.validation.constraints.*;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.openqa.selenium.By;
import org.springframework.stereotype.Service;

import static java.lang.String.format;

@Service
@Slf4j
@RequiredArgsConstructor
public class SignupElementLocatorProvider {

    public By getAccountInformationHeader() {
        return By.xpath("//div[@class='login-form']/child::h2");
    }

    public By getPasswordInput() {
        return By.xpath("//input[@id='password']");
    }

    public By getMrInput() {
        return By.xpath("//input[@id='id_gender1']");
    }

    public By getMrsInput() {
        return By.xpath("//input[@id='id_gender2']");
    }

    public By getDaysSelector() {
        return By.xpath("//select[@id='days']");
    }

    public By getMonthsSelector() {
        return By.xpath("//select[@id='months']");
    }

    public By getYearsSelector() {
        return By.xpath("//select[@id='years']");
    }

    public By getDayOption(@Min(1) @Max(31) int day) {
        return By.xpath(format("//select[@id='days']/child::option[@value='%s']", day));
    }

    public By getMonthOption(@Min(1) @Max(12) int month) {
        return By.xpath(format("//select[@id='months']/child::option[@value='%s']", month));
    }

    public By getYearOption(@Min(1900) @Max(2100) int year) {
        return By.xpath(format("//select[@id='years']/child::option[@value='%s']", year));
    }

    public By getNewsletterInput() {
        return By.xpath("//input[@id='newsletter']");
    }

    public By getAddressInformationHeader() {
        return By.xpath("//form[@action='/signup']/child::h2");
    }

    public By getFirstNameInput() {
        return By.xpath("//input[@id='first_name']");
    }

    public By getLastNameInput() {
        return By.xpath("//input[@id='last_name']");
    }

    public By getCompanyInput() {
        return By.xpath("//input[@id='company']");
    }

    public By getAddressInput() {
        return By.xpath("//input[@id='address1']");
    }

    public By getStateInput() {
        return By.xpath("//input[@id='state']");
    }

    public By getCityInput() {
        return By.xpath("//input[@id='city']");
    }

    public By getZipcodeInput() {
        return By.xpath("//input[@id='zipcode']");
    }

    public By getMobileNumberInput() {
        return By.xpath("//input[@id='mobile_number']");
    }

    public By getCountrySelector() {
        return By.xpath("//select[@id='country']");
    }

    public By getCountryOption(@NotNull@NotBlank@Size(min = 2, max = 64) String country) {
        return By.xpath(format("//select[@id='country']/child::option[@value='%s']", country));
    }

    public By getCreateAccountButton() {
        return By.xpath("//button[@data-qa='create-account']");
    }

    public By getAccountCreatedHeader() {
        return By.xpath("//h2[@data-qa='account-created']");
    }

    public By getContinueButton() {
        return By.xpath("//a[@data-qa='continue-button']");
    }

    public By getLoggedInAsLink() {
        return By.xpath("//i[@class='fa fa-user']/parent::a");
    }
}
