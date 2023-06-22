package org.hk.doghub.ui.automation;

import jakarta.validation.constraints.NotNull;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.hk.doghub.automation.e2e.selenium.elements.retrieve.ElementsRetriever;
import org.hk.doghub.automation.e2e.selenium.page.TitleVerifier;
import org.hk.doghub.automation.e2e.selenium.ui.actions.click.ClickExecutor;
import org.hk.doghub.ui.components.shared.LoginButton;
import org.hk.doghub.ui.components.shared.SignupButton;
import org.hk.doghub.ui.views.site.home.SiteHomeView;
import org.hk.doghub.ui.views.site.layout.DogHubSiteLayoutTab;
import org.hk.doghub.ui.views.site.layout.DogHubSiteLayoutTitleRouterLinkImage;
import org.hk.doghub.ui.views.site.login.LoginView;
import org.hk.doghub.ui.views.site.signup.SignupView;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
public class DogHubLandingPageService {

    private final ClickExecutor clickExecutor;

    private final TitleVerifier titleVerifier;

    private final DogHubNavigator dogHubNavigator;

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

    public void clickLogin(@NotNull WebDriver webDriver) {
        log.info("Click login started");
        clickExecutor.click(webDriver, By.className(LoginButton.CLASS_NAME));
        titleVerifier.verifyEquals(webDriver, LoginView.NAME);
        log.info("Click login completed");
    }

    public void clickSignup(@NotNull WebDriver webDriver) {
        log.info("Click signup started");
        clickExecutor.click(webDriver, By.className(SignupButton.CLASS_NAME));
        titleVerifier.verifyEquals(webDriver, SignupView.NAME);
        log.info("Click signup completed");
    }

    public List<WebElement> getTabs(@NotNull WebDriver webDriver) {
        log.info("Get tabs started");
        List<WebElement> tabs = elementsRetriever.getByPresence(webDriver, By.className(DogHubSiteLayoutTab.CLASS_NAME));
        log.info("Get tabs completed, Found {} links", tabs.size());
        return tabs;
    }

    public void browseTabs(@NotNull WebDriver webDriver) {
        log.info("Browse tabs started");
        int numberOfTabs = getNumberOfTabs(webDriver);
        for(int i=0; i<numberOfTabs; i++) {
            browseTab(webDriver, i);
        }
        log.info("Browse tabs completed");
    }
    private int getNumberOfTabs(@NotNull WebDriver webDriver) {
        log.info("Get number of tabs started");
        int result = getTabs(webDriver).size();
        log.info("Get number of tabs completed. Result is {}", result);
        return result;
    }

    private void browseTab(@NotNull WebDriver webDriver, int tabIndex) {
        log.info("Browse tab started");
        clickExecutor.click(webDriver, getTabs(webDriver).get(tabIndex));
        navigate(webDriver);
        log.info("Browse tab completed");
    }
}
