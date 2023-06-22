package org.hk.doghub.ui.automation;

import jakarta.validation.constraints.NotNull;
import org.openqa.selenium.WebDriver;

public interface DogHubNavigator {

    void navigateToLandingPage(@NotNull WebDriver webDriver);

    void navigateToSiteHomeView(@NotNull WebDriver webDriver);

    void navigateToAdoptionView(@NotNull WebDriver webDriver);

    void navigateToTrainingView(@NotNull WebDriver webDriver);

    void navigateToKnowledgeView(@NotNull WebDriver webDriver);

    void navigateToSafetyView(@NotNull WebDriver webDriver);

    void navigateToSocialView(@NotNull WebDriver webDriver);

    void navigateToStoreView(@NotNull WebDriver webDriver);

    void navigateToPlaydateView(@NotNull WebDriver webDriver);

    void navigateToBeautyView(@NotNull WebDriver webDriver);

    void navigateToHealthView(@NotNull WebDriver webDriver);

    void navigateToLoginView(@NotNull WebDriver webDriver);

    void navigateToSignupView(@NotNull WebDriver webDriver);

    void navigateToHelpView(@NotNull WebDriver webDriver);
}
