package org.hk.doghub.automation.e2e.selenium.mapping.navigation;

import jakarta.validation.constraints.NotNull;
import org.openqa.selenium.WebDriver;

public interface Navigator {

    void navigateToLandingPage(@NotNull WebDriver webDriver);

    void navigateToSignupLoginPage(@NotNull WebDriver webDriver);

    void navigateToContactUsPage(@NotNull WebDriver webDriver);

    void navigateToTestCasesPage(@NotNull WebDriver webDriver);

    void navigateToProductsPage(@NotNull WebDriver webDriver);

    void navigateToCartPage(@NotNull WebDriver webDriver);

    void navigateToApiTestingPage(@NotNull WebDriver webDriver);
}
