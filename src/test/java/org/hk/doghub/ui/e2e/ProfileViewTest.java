package org.hk.doghub.ui.e2e;

import org.hk.doghub.ui.automation.ProfileViewService;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.EnumSource;
import org.springframework.beans.factory.annotation.Autowired;

public class ProfileViewTest extends DogHubUITest {

    @Autowired
    private ProfileViewService viewService;

    @ParameterizedTest
    @EnumSource(Setup.class)
    public void shouldNavigateFromHomePage(Setup setup) {
        initiateWebDriverAndNavigateToLandingPage(setup);
        viewService.navigateFromHomePage(webDriver);
    }

    @ParameterizedTest
    @EnumSource(Setup.class)
    public void shouldDisplayId(Setup setup) {
        initiateWebDriverAndNavigateToLandingPage(setup);
        viewService.navigateFromHomePage(webDriver);
        viewService.verifyIdDisplayed(webDriver);
    }

    @ParameterizedTest
    @EnumSource(Setup.class)
    public void shouldDisplayUsername(Setup setup) {
        initiateWebDriverAndNavigateToLandingPage(setup);
        viewService.navigateFromHomePage(webDriver);
        viewService.verifyUsernameDisplayed(webDriver);
    }

    @ParameterizedTest
    @EnumSource(Setup.class)
    public void shouldDisplayTitle(Setup setup) {
        initiateWebDriverAndNavigateToLandingPage(setup);
        viewService.navigateFromHomePage(webDriver);
        viewService.verifyTitleDisplayed(webDriver);
    }

    @ParameterizedTest
    @EnumSource(Setup.class)
    public void shouldDisplayName(Setup setup) {
        initiateWebDriverAndNavigateToLandingPage(setup);
        viewService.navigateFromHomePage(webDriver);
        viewService.verifyNameDisplayed(webDriver);
    }

    @ParameterizedTest
    @EnumSource(Setup.class)
    public void shouldDisplayMobileNumber(Setup setup) {
        initiateWebDriverAndNavigateToLandingPage(setup);
        viewService.navigateFromHomePage(webDriver);
        viewService.verifyMobileNumberDisplayed(webDriver);
    }

    @ParameterizedTest
    @EnumSource(Setup.class)
    public void shouldDisplayEmail(Setup setup) {
        initiateWebDriverAndNavigateToLandingPage(setup);
        viewService.navigateFromHomePage(webDriver);
        viewService.verifyEmailDisplayed(webDriver);
    }

    @ParameterizedTest
    @EnumSource(Setup.class)
    public void shouldDisplayThumbnailPicture(Setup setup) {
        initiateWebDriverAndNavigateToLandingPage(setup);
        viewService.navigateFromHomePage(webDriver);
        viewService.verifyThumbnailPictureDisplayed(webDriver);
    }

    @ParameterizedTest
    @EnumSource(Setup.class)
    public void shouldDisplayCompany(Setup setup) {
        initiateWebDriverAndNavigateToLandingPage(setup);
        viewService.navigateFromHomePage(webDriver);
        viewService.verifyCompanyDisplayed(webDriver);
    }

    @ParameterizedTest
    @EnumSource(Setup.class)
    public void shouldDisplayCity(Setup setup) {
        initiateWebDriverAndNavigateToLandingPage(setup);
        viewService.navigateFromHomePage(webDriver);
        viewService.verifyCityDisplayed(webDriver);
    }

    @ParameterizedTest
    @EnumSource(Setup.class)
    public void shouldDisplayStreetName(Setup setup) {
        initiateWebDriverAndNavigateToLandingPage(setup);
        viewService.navigateFromHomePage(webDriver);
        viewService.verifyStreetNameDisplayed(webDriver);
    }

    @ParameterizedTest
    @EnumSource(Setup.class)
    public void shouldDisplayPostcode(Setup setup) {
        initiateWebDriverAndNavigateToLandingPage(setup);
        viewService.navigateFromHomePage(webDriver);
        viewService.verifyPostcodeDisplayed(webDriver);
    }

    @ParameterizedTest
    @EnumSource(Setup.class)
    public void shouldDisplayFields(Setup setup) {
        initiateWebDriverAndNavigateToLandingPage(setup);
        viewService.navigateFromHomePage(webDriver);
        viewService.verifyIdDisplayed(webDriver);
        viewService.verifyUsernameDisplayed(webDriver);
        viewService.verifyNameDisplayed(webDriver);
        viewService.verifyMobileNumberDisplayed(webDriver);
        viewService.verifyEmailDisplayed(webDriver);
        viewService.verifyThumbnailPictureDisplayed(webDriver);
        viewService.verifyCompanyDisplayed(webDriver);
        viewService.verifyCityDisplayed(webDriver);
        viewService.verifyStreetNameDisplayed(webDriver);
        viewService.verifyPostcodeDisplayed(webDriver);
    }
}
