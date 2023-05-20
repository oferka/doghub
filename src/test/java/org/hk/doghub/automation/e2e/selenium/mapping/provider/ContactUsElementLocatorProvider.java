package org.hk.doghub.automation.e2e.selenium.mapping.provider;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.openqa.selenium.By;
import org.springframework.stereotype.Service;

@Service
@Slf4j
@RequiredArgsConstructor
public class ContactUsElementLocatorProvider {

    public By getContactUsHeader() {
        return By.xpath("//div[@class='col-sm-12']/child::h2");
    }

    public By getGetInTouchHeader() {
        return By.xpath("//div[@class='contact-form']/child::h2");
    }

    public By getFeedbackForUsHeader() {
        return By.xpath("//div[@class='contact-info']/child::h2");
    }

    public By getNameInput() {
        return By.xpath("//input[@data-qa='name']");
    }

    public By getEmailInput() {
        return By.xpath("//input[@data-qa='email']");
    }

    public By getSubjectInput() {
        return By.xpath("//input[@data-qa='subject']");
    }

    public By getMessageInput() {
        return By.xpath("//textarea[@data-qa='message']");
    }

    public By getSubmitButton() {
        return By.xpath("//input[@data-qa='submit-button']");
    }

    public By getSubmittedSuccessfullyMessage() {
        return By.xpath("//div[@class='status alert alert-success']");
    }

    public By getHomeButton() {
        return By.xpath("//a[@class='btn btn-success']");
    }

    public By getUploadFileInput() {
        return By.xpath("//input[@name='upload_file']");
    }
}
