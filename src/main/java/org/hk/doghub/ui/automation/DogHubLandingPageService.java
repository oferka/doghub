package org.hk.doghub.ui.automation;

import jakarta.validation.constraints.NotNull;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.hk.doghub.automation.e2e.selenium.element.highlight.ElementHighlighter;
import org.hk.doghub.automation.e2e.selenium.elements.retrieve.ElementsRetriever;
import org.hk.doghub.automation.e2e.selenium.page.TitleVerifier;
import org.hk.doghub.automation.e2e.selenium.ui.actions.click.ClickExecutor;
import org.hk.doghub.ui.views.site.home.SiteHomeView;
import org.hk.doghub.ui.views.site.layout.DogHubSiteLayoutTitleRouterLinkImage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Slf4j
public class DogHubLandingPageService {

    private final ClickExecutor clickExecutor;

    private final TitleVerifier titleVerifier;

    private final DogHubNavigator dogHubNavigator;

    private final ElementHighlighter elementHighlighter;

    private final ElementsRetriever elementsRetriever;

    public void navigate(@NotNull WebDriver webDriver) {
        dogHubNavigator.navigateToLandingPage(webDriver);
        titleVerifier.verifyEquals(webDriver, SiteHomeView.NAME);
    }

    public void clickLogo(@NotNull WebDriver webDriver) {
        log.info("Click logo started");
        clickExecutor.click(webDriver, By.className(DogHubSiteLayoutTitleRouterLinkImage.CLASS_NAME));
        titleVerifier.verifyEquals(webDriver, SiteHomeView.NAME);
        log.info("Click logo completed");
    }

    public void clickHome(@NotNull WebDriver webDriver) {
        log.info("Click home started");
        clickExecutor.click(webDriver, By.className(DogHubSiteLayoutTitleRouterLinkImage.CLASS_NAME));
        titleVerifier.verifyEquals(webDriver, SiteHomeView.NAME);
        log.info("Click home completed");
    }

//    public void clickSignupLogin(@NotNull WebDriver webDriver) {
//        log.info("Click signup/login started");
//        clickExecutor.click(webDriver, landingPageElementLocatorProvider.getSignupLoginLink());
//        titleVerifier.verifyEquals(webDriver, SignupLoginPage.TITLE);
//        log.info("Click signup/login completed");
//    }
//
//    public void clickCart(@NotNull WebDriver webDriver) {
//        log.info("Click cart started");
//        clickExecutor.click(webDriver, landingPageElementLocatorProvider.getCartLink());
//        titleVerifier.verifyEquals(webDriver, CartPage.TITLE);
//        log.info("Click cart completed");
//    }
//
//    public void clickApiTesting(@NotNull WebDriver webDriver) {
//        log.info("Click api testing started");
//        clickExecutor.click(webDriver, landingPageElementLocatorProvider.getApiTestingLink());
//        titleVerifier.verifyEquals(webDriver, ApiTestingPage.TITLE);
//        log.info("Click api testing completed");
//    }
//
//    public void deleteCurrentAccount(@NotNull WebDriver webDriver) {
//        log.info("Delete current account started");
//        clickDeleteAccount(webDriver);
//        verifyAccountDeletedHeaderVisible(webDriver);
//        clickContinue(webDriver);
//        log.info("Delete current account completed");
//    }
//
//    public void logoutCurrentUser(@NotNull WebDriver webDriver) {
//        log.info("Logout current user started");
//        clickLogout(webDriver);
//        verifyLoginHeaderVisible(webDriver);
//        log.info("Logout current user completed");
//    }
//
//    public void clickContactUs(@NotNull WebDriver webDriver) {
//        log.info("Click contact us started");
//        clickExecutor.click(webDriver, landingPageElementLocatorProvider.getContactUsLink());
//        titleVerifier.verifyEquals(webDriver, ContactUsPage.TITLE);
//        log.info("Click contact us completed");
//    }
//
//    public void clickTestCases(@NotNull WebDriver webDriver) {
//        log.info("Click test cases started");
//        clickExecutor.click(webDriver, landingPageElementLocatorProvider.getTestCasesLink());
//        titleVerifier.verifyEquals(webDriver, TestCasesPage.TITLE);
//        log.info("Click test cases completed");
//    }
//
//    public List<WebElement> getNavigationBarLinks(@NotNull WebDriver webDriver) {
//        log.info("Get navigation bar elements started");
//        List<WebElement> navigationLinks = elementsRetriever.getByPresence(webDriver, landingPageElementLocatorProvider.getNavigationBarLinks());
//        log.info("Get navigation bar elements completed, Found {} links", navigationLinks.size());
//        return navigationLinks;
//    }
//
//    public void browseNavigationBarLinks(@NotNull WebDriver webDriver) {
//        log.info("Browse navigation bar links started");
//        int numberOfNavigationLinks = getNumberOfNavigationBarLinks(webDriver);
//        for(int i=1; i<=numberOfNavigationLinks; i++) {
//            browseNavigationBarLink(webDriver, landingPageElementLocatorProvider.getNavigationBarLink(i));
//        }
//        log.info("Browse navigation bar links completed");
//    }
//
//    private void browseNavigationBarLink(@NotNull WebDriver webDriver, @NotNull By navigationBrLinkLocator) {
//        log.info("Browse navigation bar link started");
//        clickExecutor.click(webDriver, navigationBrLinkLocator);
//        navigate(webDriver);
//        log.info("Browse navigation bar link completed");
//    }
//
//    private int getNumberOfNavigationBarLinks(@NotNull WebDriver webDriver) {
//        log.info("Get number of navigation bar links started");
//        int result = getNavigationBarLinks(webDriver).size();
//        log.info("Get number of navigation bar links completed. Result is {}", result);
//        return result;
//    }
//
//    private void clickDeleteAccount(@NotNull WebDriver webDriver) {
//        log.info("Click continue started");
//        clickExecutor.click(webDriver, landingPageElementLocatorProvider.getDeleteAccountButton());
//        titleVerifier.verifyEquals(webDriver, AccountCreatedPage.TITLE);
//        log.info("Click continue completed");
//    }
//
//    private void verifyAccountDeletedHeaderVisible(@NotNull WebDriver webDriver) {
//        log.info("Verify that account deleted header is visible started");
//        elementHighlighter.eventHighlight(webDriver, landingPageElementLocatorProvider.getAccountDeletedHeader());
//        log.info("Verify that account deleted header is visible completed");
//    }
//
//    private void clickContinue(@NotNull WebDriver webDriver) {
//        log.info("Click continue started");
//        clickExecutor.click(webDriver, landingPageElementLocatorProvider.getContinueButton());
//        titleVerifier.verifyEquals(webDriver, LandingPage.TITLE);
//        log.info("Click continue completed");
//    }
//
//    private void clickLogout(@NotNull WebDriver webDriver) {
//        log.info("Click logout started");
//        clickExecutor.click(webDriver, landingPageElementLocatorProvider.getLogoutLink());
//        titleVerifier.verifyEquals(webDriver, SignupLoginPage.TITLE);
//        log.info("Click logout completed");
//    }
//
//    private void verifyLoginHeaderVisible(@NotNull WebDriver webDriver) {
//        log.info("Verify that login header is visible started");
//        elementHighlighter.eventHighlight(webDriver, signupLoginElementLocatorProvider.getLoginHeader());
//        log.info("Verify that login header is visible completed");
//    }
}
