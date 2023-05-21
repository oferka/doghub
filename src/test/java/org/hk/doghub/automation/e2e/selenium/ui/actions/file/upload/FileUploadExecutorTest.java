package org.hk.doghub.automation.e2e.selenium.ui.actions.file.upload;

import org.hk.doghub.automation.e2e.selenium.BaseTest;
import org.hk.doghub.automation.e2e.selenium.Setup;
import org.hk.doghub.automation.e2e.selenium.mapping.provider.ContactUsElementLocatorProvider;
import org.hk.doghub.automation.e2e.selenium.mapping.provider.LandingPageElementLocatorProvider;
import org.hk.doghub.automation.e2e.selenium.ui.actions.click.ClickExecutor;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.EnumSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ClassPathResource;

import java.io.File;
import java.io.IOException;

class FileUploadExecutorTest extends BaseTest {

    @Autowired
    private FileUploadExecutor fileUploadExecutor;

    @Autowired
    private ClickExecutor clickExecutor;

    @Autowired
    private LandingPageElementLocatorProvider landingPageElementLocatorProvider;

    @Autowired
    private ContactUsElementLocatorProvider contactUsElementLocatorProvider;

    @ParameterizedTest
    @EnumSource(Setup.class)
    void shouldUpload(Setup setup) throws IOException {
        initiateWebDriverAndNavigateToContactUsPage(setup);
        fileUploadExecutor.upload(webDriver, contactUsElementLocatorProvider.getUploadFileInput(), getFile());
    }

    private void initiateWebDriverAndNavigateToContactUsPage(Setup setup) {
        initiateWebDriverAndNavigateToTestPage(setup);
        clickExecutor.click(webDriver, landingPageElementLocatorProvider.getContactUsLink());
    }

    private File getFile() throws IOException {
        return new ClassPathResource("contact_us.gif").getFile();
    }
}