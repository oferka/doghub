package org.hk.doghub.ui.e2e;

import org.hk.doghub.ui.automation.ProfileViewService;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.EnumSource;
import org.springframework.beans.factory.annotation.Autowired;

import static org.junit.jupiter.api.Assertions.assertNotNull;

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
    public void shouldGetIdValue(Setup setup) {
        initiateWebDriverAndNavigateToLandingPage(setup);
        viewService.navigateFromHomePage(webDriver);
        assertNotNull(viewService.getIdValue(webDriver));
    }

    @ParameterizedTest
    @EnumSource(Setup.class)
    public void shouldNotAllowEditingId(Setup setup) {
        initiateWebDriverAndNavigateToLandingPage(setup);
        viewService.navigateFromHomePage(webDriver);
        viewService.verifyIdReadOnly(webDriver);
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
    public void shouldGetUsernameValue(Setup setup) {
        initiateWebDriverAndNavigateToLandingPage(setup);
        viewService.navigateFromHomePage(webDriver);
        assertNotNull(viewService.getUsernameValue(webDriver));
    }

    @ParameterizedTest
    @EnumSource(Setup.class)
    public void shouldNotAllowEditingUsername(Setup setup) {
        initiateWebDriverAndNavigateToLandingPage(setup);
        viewService.navigateFromHomePage(webDriver);
        viewService.verifyUsernameReadOnly(webDriver);
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
    public void shouldGetTitleValue(Setup setup) {
        initiateWebDriverAndNavigateToLandingPage(setup);
        viewService.navigateFromHomePage(webDriver);
        assertNotNull(viewService.getTitleValue(webDriver));
    }

    @ParameterizedTest
    @EnumSource(Setup.class)
    public void shouldEnterTitle(Setup setup) {
        initiateWebDriverAndNavigateToLandingPage(setup);
        viewService.navigateFromHomePage(webDriver);
        viewService.enterTitle(webDriver);
        viewService.clickSave(webDriver);
        viewService.verifySavedSuccessfullyNotificationDisplayed(webDriver);
    }

    @ParameterizedTest
    @EnumSource(Setup.class)
    public void shouldValidateTitle(Setup setup) {
        initiateWebDriverAndNavigateToLandingPage(setup);
        viewService.navigateFromHomePage(webDriver);
        viewService.enterInvalidTitle(webDriver);
        viewService.clickSave(webDriver);
        viewService.verifySaveFailedWithInvalidInputNotificationDisplayed(webDriver);
        viewService.enterTitle(webDriver);
        viewService.clickSave(webDriver);
        viewService.verifySavedSuccessfullyNotificationDisplayed(webDriver);
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
    public void shouldGetNameValue(Setup setup) {
        initiateWebDriverAndNavigateToLandingPage(setup);
        viewService.navigateFromHomePage(webDriver);
        assertNotNull(viewService.getNameValue(webDriver));
    }

    @ParameterizedTest
    @EnumSource(Setup.class)
    public void shouldEnterName(Setup setup) {
        initiateWebDriverAndNavigateToLandingPage(setup);
        viewService.navigateFromHomePage(webDriver);
        viewService.enterName(webDriver);
        viewService.clickSave(webDriver);
        viewService.verifySavedSuccessfullyNotificationDisplayed(webDriver);
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
    public void shouldGetMobileNumberValue(Setup setup) {
        initiateWebDriverAndNavigateToLandingPage(setup);
        viewService.navigateFromHomePage(webDriver);
        assertNotNull(viewService.getMobileNumberValue(webDriver));
    }

    @ParameterizedTest
    @EnumSource(Setup.class)
    public void shouldEnterMobileNumber(Setup setup) {
        initiateWebDriverAndNavigateToLandingPage(setup);
        viewService.navigateFromHomePage(webDriver);
        viewService.enterMobileNumber(webDriver);
        viewService.clickSave(webDriver);
        viewService.verifySavedSuccessfullyNotificationDisplayed(webDriver);
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
    public void shouldGetEmailValue(Setup setup) {
        initiateWebDriverAndNavigateToLandingPage(setup);
        viewService.navigateFromHomePage(webDriver);
        assertNotNull(viewService.getEmailValue(webDriver));
    }

    @ParameterizedTest
    @EnumSource(Setup.class)
    public void shouldEnterEmail(Setup setup) {
        initiateWebDriverAndNavigateToLandingPage(setup);
        viewService.navigateFromHomePage(webDriver);
        viewService.enterEmail(webDriver);
        viewService.clickSave(webDriver);
        viewService.verifySavedSuccessfullyNotificationDisplayed(webDriver);
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
    public void shouldGetThumbnailPictureValue(Setup setup) {
        initiateWebDriverAndNavigateToLandingPage(setup);
        viewService.navigateFromHomePage(webDriver);
        assertNotNull(viewService.getThumbnailPictureValue(webDriver));
    }

    @ParameterizedTest
    @EnumSource(Setup.class)
    public void shouldEnterThumbnailPicture(Setup setup) {
        initiateWebDriverAndNavigateToLandingPage(setup);
        viewService.navigateFromHomePage(webDriver);
        viewService.enterThumbnailPicture(webDriver);
        viewService.clickSave(webDriver);
        viewService.verifySavedSuccessfullyNotificationDisplayed(webDriver);
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
    public void shouldGetCompanyValue(Setup setup) {
        initiateWebDriverAndNavigateToLandingPage(setup);
        viewService.navigateFromHomePage(webDriver);
        assertNotNull(viewService.getCompanyValue(webDriver));
    }

    @ParameterizedTest
    @EnumSource(Setup.class)
    public void shouldEnterCompany(Setup setup) {
        initiateWebDriverAndNavigateToLandingPage(setup);
        viewService.navigateFromHomePage(webDriver);
        viewService.enterCompany(webDriver);
        viewService.clickSave(webDriver);
        viewService.verifySavedSuccessfullyNotificationDisplayed(webDriver);
    }

    @ParameterizedTest
    @EnumSource(Setup.class)
    public void shouldDisplayDateOfBirth(Setup setup) {
        initiateWebDriverAndNavigateToLandingPage(setup);
        viewService.navigateFromHomePage(webDriver);
        viewService.verifyDateOfBirthDisplayed(webDriver);
    }

    @ParameterizedTest
    @EnumSource(Setup.class)
    public void shouldGetDateOfBirthValue(Setup setup) {
        initiateWebDriverAndNavigateToLandingPage(setup);
        viewService.navigateFromHomePage(webDriver);
        assertNotNull(viewService.getDateOfBirthValue(webDriver));
    }

    @ParameterizedTest
    @EnumSource(Setup.class)
    public void shouldEnterDateOfBirth(Setup setup) {
        initiateWebDriverAndNavigateToLandingPage(setup);
        viewService.navigateFromHomePage(webDriver);
        viewService.enterDateOfBirth(webDriver);
        viewService.clickSave(webDriver);
        viewService.verifySavedSuccessfullyNotificationDisplayed(webDriver);
    }

    @ParameterizedTest
    @EnumSource(Setup.class)
    public void shouldDisplayDateOfRegistration(Setup setup) {
        initiateWebDriverAndNavigateToLandingPage(setup);
        viewService.navigateFromHomePage(webDriver);
        viewService.verifyDateOfRegistrationDisplayed(webDriver);
    }

    @ParameterizedTest
    @EnumSource(Setup.class)
    public void shouldGetDateOfRegistrationValue(Setup setup) {
        initiateWebDriverAndNavigateToLandingPage(setup);
        viewService.navigateFromHomePage(webDriver);
        assertNotNull(viewService.getDateOfRegistrationValue(webDriver));
    }

    @ParameterizedTest
    @EnumSource(Setup.class)
    public void shouldNotAllowEditingDateOfRegistration(Setup setup) {
        initiateWebDriverAndNavigateToLandingPage(setup);
        viewService.navigateFromHomePage(webDriver);
        viewService.verifyDateOfRegistrationReadOnly(webDriver);
    }

    @ParameterizedTest
    @EnumSource(Setup.class)
    public void shouldDisplayCountry(Setup setup) {
        initiateWebDriverAndNavigateToLandingPage(setup);
        viewService.navigateFromHomePage(webDriver);
        viewService.verifyCountryDisplayed(webDriver);
    }

    @ParameterizedTest
    @EnumSource(Setup.class)
    public void shouldGetCountryValue(Setup setup) {
        initiateWebDriverAndNavigateToLandingPage(setup);
        viewService.navigateFromHomePage(webDriver);
        assertNotNull(viewService.getCountryValue(webDriver));
    }

    @ParameterizedTest
    @EnumSource(Setup.class)
    public void shouldEnterCountry(Setup setup) {
        initiateWebDriverAndNavigateToLandingPage(setup);
        viewService.navigateFromHomePage(webDriver);
        viewService.enterCountry(webDriver);
        viewService.clickSave(webDriver);
        viewService.verifySavedSuccessfullyNotificationDisplayed(webDriver);
    }

    @ParameterizedTest
    @EnumSource(Setup.class)
    public void shouldDisplayState(Setup setup) {
        initiateWebDriverAndNavigateToLandingPage(setup);
        viewService.navigateFromHomePage(webDriver);
        viewService.verifyStateDisplayed(webDriver);
    }

    @ParameterizedTest
    @EnumSource(Setup.class)
    public void shouldGetStateValue(Setup setup) {
        initiateWebDriverAndNavigateToLandingPage(setup);
        viewService.navigateFromHomePage(webDriver);
        assertNotNull(viewService.getStateValue(webDriver));
    }

    @ParameterizedTest
    @EnumSource(Setup.class)
    public void shouldEnterState(Setup setup) {
        initiateWebDriverAndNavigateToLandingPage(setup);
        viewService.navigateFromHomePage(webDriver);
        viewService.enterState(webDriver);
        viewService.clickSave(webDriver);
        viewService.verifySavedSuccessfullyNotificationDisplayed(webDriver);
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
    public void shouldGetCityValue(Setup setup) {
        initiateWebDriverAndNavigateToLandingPage(setup);
        viewService.navigateFromHomePage(webDriver);
        assertNotNull(viewService.getCityValue(webDriver));
    }

    @ParameterizedTest
    @EnumSource(Setup.class)
    public void shouldEnterCity(Setup setup) {
        initiateWebDriverAndNavigateToLandingPage(setup);
        viewService.navigateFromHomePage(webDriver);
        viewService.enterCity(webDriver);
        viewService.clickSave(webDriver);
        viewService.verifySavedSuccessfullyNotificationDisplayed(webDriver);
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
    public void shouldGetStreetNameValue(Setup setup) {
        initiateWebDriverAndNavigateToLandingPage(setup);
        viewService.navigateFromHomePage(webDriver);
        assertNotNull(viewService.getStreetNameValue(webDriver));
    }

    @ParameterizedTest
    @EnumSource(Setup.class)
    public void shouldEnterStreetName(Setup setup) {
        initiateWebDriverAndNavigateToLandingPage(setup);
        viewService.navigateFromHomePage(webDriver);
        viewService.enterStreetName(webDriver);
        viewService.clickSave(webDriver);
        viewService.verifySavedSuccessfullyNotificationDisplayed(webDriver);
    }

    @ParameterizedTest
    @EnumSource(Setup.class)
    public void shouldDisplayStreetNumber(Setup setup) {
        initiateWebDriverAndNavigateToLandingPage(setup);
        viewService.navigateFromHomePage(webDriver);
        viewService.verifyStreetNumberDisplayed(webDriver);
    }

    @ParameterizedTest
    @EnumSource(Setup.class)
    public void shouldGetStreetNumberValue(Setup setup) {
        initiateWebDriverAndNavigateToLandingPage(setup);
        viewService.navigateFromHomePage(webDriver);
        assertNotNull(viewService.getStreetNumberValue(webDriver));
    }

    @ParameterizedTest
    @EnumSource(Setup.class)
    public void shouldEnterStreetNumber(Setup setup) {
        initiateWebDriverAndNavigateToLandingPage(setup);
        viewService.navigateFromHomePage(webDriver);
        viewService.enterStreetNumber(webDriver);
        viewService.clickSave(webDriver);
        viewService.verifySavedSuccessfullyNotificationDisplayed(webDriver);
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
    public void shouldGetPostcodeValue(Setup setup) {
        initiateWebDriverAndNavigateToLandingPage(setup);
        viewService.navigateFromHomePage(webDriver);
        assertNotNull(viewService.getPostcodeValue(webDriver));
    }

    @ParameterizedTest
    @EnumSource(Setup.class)
    public void shouldEnterPostcode(Setup setup) {
        initiateWebDriverAndNavigateToLandingPage(setup);
        viewService.navigateFromHomePage(webDriver);
        viewService.enterPostcode(webDriver);
        viewService.clickSave(webDriver);
        viewService.verifySavedSuccessfullyNotificationDisplayed(webDriver);
    }

    @ParameterizedTest
    @EnumSource(Setup.class)
    public void shouldDisplayFields(Setup setup) {
        initiateWebDriverAndNavigateToLandingPage(setup);
        viewService.navigateFromHomePage(webDriver);
        viewService.verifyIdDisplayed(webDriver);
        viewService.verifyUsernameDisplayed(webDriver);
        viewService.verifyTitleDisplayed(webDriver);
        viewService.verifyNameDisplayed(webDriver);
        viewService.verifyMobileNumberDisplayed(webDriver);
        viewService.verifyEmailDisplayed(webDriver);
        viewService.verifyThumbnailPictureDisplayed(webDriver);
        viewService.verifyCompanyDisplayed(webDriver);
        viewService.verifyDateOfBirthDisplayed(webDriver);
        viewService.verifyDateOfRegistrationDisplayed(webDriver);
        viewService.verifyCountryDisplayed(webDriver);
        viewService.verifyStateDisplayed(webDriver);
        viewService.verifyCityDisplayed(webDriver);
        viewService.verifyStreetNameDisplayed(webDriver);
        viewService.verifyStreetNumberDisplayed(webDriver);
        viewService.verifyPostcodeDisplayed(webDriver);
    }

    @ParameterizedTest
    @EnumSource(Setup.class)
    public void shouldGetFieldValues(Setup setup) {
        initiateWebDriverAndNavigateToLandingPage(setup);
        viewService.navigateFromHomePage(webDriver);
        viewService.getIdValue(webDriver);
        viewService.getUsernameValue(webDriver);
        viewService.getTitleValue(webDriver);
        viewService.getNameValue(webDriver);
        viewService.getMobileNumberValue(webDriver);
        viewService.getEmailValue(webDriver);
        viewService.getTitleValue(webDriver);
        viewService.getCompanyValue(webDriver);
        viewService.getDateOfBirthValue(webDriver);
        viewService.getDateOfRegistrationValue(webDriver);
        viewService.getCountryValue(webDriver);
        viewService.getStateValue(webDriver);
        viewService.getCityValue(webDriver);
        viewService.getStreetNameValue(webDriver);
        viewService.getStreetNumberValue(webDriver);
        viewService.getPostcodeValue(webDriver);
    }

    @ParameterizedTest
    @EnumSource(Setup.class)
    public void shouldEnterFields(Setup setup) {
        initiateWebDriverAndNavigateToLandingPage(setup);
        viewService.navigateFromHomePage(webDriver);
        viewService.enterTitle(webDriver);
        viewService.enterName(webDriver);
        viewService.enterMobileNumber(webDriver);
        viewService.enterEmail(webDriver);
        viewService.enterThumbnailPicture(webDriver);
        viewService.enterCompany(webDriver);
        viewService.enterDateOfBirth(webDriver);
        viewService.enterCountry(webDriver);
        viewService.enterState(webDriver);
        viewService.enterCity(webDriver);
        viewService.enterStreetName(webDriver);
        viewService.enterStreetNumber(webDriver);
        viewService.enterPostcode(webDriver);
        viewService.clickSave(webDriver);
        viewService.verifySavedSuccessfullyNotificationDisplayed(webDriver);
    }

    @ParameterizedTest
    @EnumSource(Setup.class)
    public void shouldClickSave(Setup setup) {
        initiateWebDriverAndNavigateToLandingPage(setup);
        viewService.navigateFromHomePage(webDriver);
        viewService.clickSave(webDriver);
    }

    @ParameterizedTest
    @EnumSource(Setup.class)
    public void shouldDisplaySavedSuccessfullyNotification(Setup setup) {
        initiateWebDriverAndNavigateToLandingPage(setup);
        viewService.navigateFromHomePage(webDriver);
        viewService.clickSave(webDriver);
        viewService.verifySavedSuccessfullyNotificationDisplayed(webDriver);
    }

    @ParameterizedTest
    @EnumSource(Setup.class)
    public void shouldClickCancel(Setup setup) {
        initiateWebDriverAndNavigateToLandingPage(setup);
        viewService.navigateFromHomePage(webDriver);
        viewService.clickCancel(webDriver);
    }
}
