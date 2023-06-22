package org.hk.doghub.ui.e2e;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.EnumSource;

public class DogHubLandingPageServiceTest extends BaseLandingPageTest {

//    @Autowired
//    private SignupLoginService signupLoginService;
//
//    @Autowired
//    private UserGeneratorService userGeneratorService;
//
//    @Autowired
//    private ElementHighlighter elementHighlighter;

    @ParameterizedTest
    @EnumSource(Setup.class)
    public void shouldNavigateToLandingPage(Setup setup) {
        initiateWebDriverAndNavigateToLandingPage(setup);
    }

    @ParameterizedTest
    @EnumSource(Setup.class)
    public void shouldClickLogo(Setup setup) {
        initiateWebDriverAndNavigateToLandingPage(setup);
        landingPageService.clickLogo(webDriver);
    }

    @ParameterizedTest
    @EnumSource(Setup.class)
    public void shouldClickHome(Setup setup) {
        initiateWebDriverAndNavigateToLandingPage(setup);
        landingPageService.clickHome(webDriver);
    }

    @ParameterizedTest
    @EnumSource(Setup.class)
    public void shouldClickLogin(Setup setup) {
        initiateWebDriverAndNavigateToLandingPage(setup);
        landingPageService.clickLogin(webDriver);
    }

    @ParameterizedTest
    @EnumSource(Setup.class)
    public void shouldClickSignup(Setup setup) {
        initiateWebDriverAndNavigateToLandingPage(setup);
        landingPageService.clickSignup(webDriver);
    }

//    @ParameterizedTest
//    @EnumSource(Setup.class)
//    public void shouldClickCart(Setup setup) {
//        initiateWebDriverAndNavigateToLandingPage(setup);
//        landingPageService.clickCart(webDriver);
//    }
//
//    @ParameterizedTest
//    @EnumSource(Setup.class)
//    public void shouldClickApiTesting(Setup setup) {
//        initiateWebDriverAndNavigateToLandingPage(setup);
//        landingPageService.clickApiTesting(webDriver);
//    }
//
//    @ParameterizedTest
//    @EnumSource(Setup.class)
//    public void shouldDeleteCurrentAccount(Setup setup) {
//        initiateWebDriverAndNavigateToLandingPage(setup);
//        User user = userGeneratorService.generate();
//        signupLoginService.registerUser(webDriver, user);
//        landingPageService.deleteCurrentAccount(webDriver);
//    }
//
//    @ParameterizedTest
//    @EnumSource(Setup.class)
//    public void shouldLogoutCurrentUser(Setup setup) {
//        initiateWebDriverAndNavigateToLandingPage(setup);
//        User user = userGeneratorService.generate();
//        signupLoginService.registerUser(webDriver, user);
//        landingPageService.logoutCurrentUser(webDriver);
//    }
//
//    @ParameterizedTest
//    @EnumSource(Setup.class)
//    public void shouldClickContactUs(Setup setup) {
//        initiateWebDriverAndNavigateToLandingPage(setup);
//        landingPageService.clickContactUs(webDriver);
//    }
//
//    @ParameterizedTest
//    @EnumSource(Setup.class)
//    public void shouldClickTestCases(Setup setup) {
//        initiateWebDriverAndNavigateToLandingPage(setup);
//        landingPageService.clickTestCases(webDriver);
//    }
//
//    @ParameterizedTest
//    @EnumSource(Setup.class)
//    public void shouldGetNavigationLinks(Setup setup) {
//        initiateWebDriverAndNavigateToLandingPage(setup);
//        List<WebElement> navigationElements = landingPageService.getNavigationBarLinks(webDriver);
//        for(WebElement navigationElement : navigationElements) {
//            elementHighlighter.eventHighlight(webDriver, navigationElement);
//        }
//    }
//
//    @ParameterizedTest
//    @EnumSource(Setup.class)
//    public void shouldBrowseNavigationLinks(Setup setup) {
//        initiateWebDriverAndNavigateToLandingPage(setup);
//        landingPageService.browseNavigationBarLinks(webDriver);
//    }
}
