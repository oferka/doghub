package org.hk.doghub.ui.automation;

import jakarta.validation.constraints.NotNull;
import org.openqa.selenium.WebDriver;

public interface DogHubNavigator {

    void navigateToLandingPage(@NotNull WebDriver webDriver);

    void navigateToSiteHomePage(@NotNull WebDriver webDriver);
//
//    void navigateToContactUsPage(@NotNull WebDriver webDriver);
//
//    void navigateToTestCasesPage(@NotNull WebDriver webDriver);
//
//    void navigateToProductsPage(@NotNull WebDriver webDriver);
//
//    void navigateToCartPage(@NotNull WebDriver webDriver);
//
//    void navigateToApiTestingPage(@NotNull WebDriver webDriver);
}
