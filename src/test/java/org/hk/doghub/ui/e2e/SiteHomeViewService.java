package org.hk.doghub.ui.e2e;

import jakarta.validation.constraints.NotNull;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.hk.doghub.automation.e2e.selenium.element.display.status.ElementDisplayStatusRetriever;
import org.hk.doghub.automation.e2e.selenium.elements.retrieve.ElementsRetriever;
import org.hk.doghub.automation.e2e.selenium.page.TitleVerifier;
import org.hk.doghub.automation.e2e.selenium.ui.actions.click.ClickExecutor;
import org.hk.doghub.ui.components.shared.LoginButton;
import org.hk.doghub.ui.components.shared.SignupButton;
import org.hk.doghub.ui.components.shared.user.UserMenuBar;
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

import static java.lang.String.format;

@Service
@RequiredArgsConstructor
@Slf4j
public class SiteHomeViewService {

    private final ClickExecutor clickExecutor;

    private final TitleVerifier titleVerifier;

    private final DogHubNavigator navigator;

    private final ElementsRetriever elementsRetriever;

    private final ElementDisplayStatusRetriever elementDisplayStatusRetriever;

    public void navigateFromHomePage(@NotNull WebDriver webDriver) {
        clickExecutor.click(webDriver, By.id(format("%s-%s", DogHubSiteLayoutTab.CLASS_NAME, SiteHomeView.NAME)));
        titleVerifier.verifyEquals(webDriver, SiteHomeView.NAME);
    }

    public void navigateDirectly(@NotNull WebDriver webDriver) {
        navigator.navigateToSiteHomeView(webDriver);
        titleVerifier.verifyEquals(webDriver, SiteHomeView.NAME);
    }

    public void clickLogo(@NotNull WebDriver webDriver) {
        clickExecutor.click(webDriver, By.className(DogHubSiteLayoutTitleRouterLinkImage.CLASS_NAME));
        titleVerifier.verifyEquals(webDriver, SiteHomeView.NAME);
    }

    public void clickHome(@NotNull WebDriver webDriver) {
        clickExecutor.click(webDriver, By.className(DogHubSiteLayoutTitleRouterLinkImage.CLASS_NAME));
        titleVerifier.verifyEquals(webDriver, SiteHomeView.NAME);
    }

    public void clickLogin(@NotNull WebDriver webDriver) {
        clickExecutor.click(webDriver, By.className(LoginButton.CLASS_NAME));
        titleVerifier.verifyEquals(webDriver, LoginView.NAME);
    }

    public void clickSignup(@NotNull WebDriver webDriver) {
        clickExecutor.click(webDriver, By.className(SignupButton.CLASS_NAME));
        titleVerifier.verifyEquals(webDriver, SignupView.NAME);
    }

    public List<WebElement> getTabs(@NotNull WebDriver webDriver) {
        return elementsRetriever.getByPresence(webDriver, By.className(DogHubSiteLayoutTab.CLASS_NAME));
    }

    public void browseTabs(@NotNull WebDriver webDriver) {
        int numberOfTabs = getNumberOfTabs(webDriver);
        for(int i=0; i<numberOfTabs; i++) {
            browseTab(webDriver, i);
        }
    }
    private int getNumberOfTabs(@NotNull WebDriver webDriver) {
        return getTabs(webDriver).size();
    }

    private void browseTab(@NotNull WebDriver webDriver, int tabIndex) {
        clickExecutor.click(webDriver, getTabs(webDriver).get(tabIndex));
        navigateDirectly(webDriver);
    }

    public boolean isLoggedIn(@NotNull WebDriver webDriver) {
        titleVerifier.verifyEquals(webDriver, SiteHomeView.NAME);
        return elementDisplayStatusRetriever.isDisplayed(webDriver, By.className(UserMenuBar.CLASS_NAME), true);
    }
}
