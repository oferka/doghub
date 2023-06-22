package org.hk.doghub.ui.automation;

import jakarta.validation.constraints.NotNull;
import org.openqa.selenium.WebDriver;

public interface DogHubNavigator {

    void navigateToLandingPage(@NotNull WebDriver webDriver);

    void navigateToSiteHomeView(@NotNull WebDriver webDriver);

    void navigateToAdoptionView(@NotNull WebDriver webDriver);
}
