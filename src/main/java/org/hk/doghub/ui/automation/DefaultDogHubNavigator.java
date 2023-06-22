package org.hk.doghub.ui.automation;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.hk.doghub.ui.views.site.adoption.AdoptionView;
import org.hk.doghub.ui.views.site.beauty.BeautyView;
import org.hk.doghub.ui.views.site.health.HealthView;
import org.hk.doghub.ui.views.site.home.SiteHomeView;
import org.hk.doghub.ui.views.site.knowledge.KnowledgeView;
import org.hk.doghub.ui.views.site.login.LoginView;
import org.hk.doghub.ui.views.site.playdate.PlaydateView;
import org.hk.doghub.ui.views.site.safety.SafetyView;
import org.hk.doghub.ui.views.site.signup.SignupView;
import org.hk.doghub.ui.views.site.social.SocialView;
import org.hk.doghub.ui.views.site.store.StoreView;
import org.hk.doghub.ui.views.site.training.TrainingView;
import org.openqa.selenium.WebDriver;
import org.springframework.stereotype.Service;

import java.net.URI;

@Service
@RequiredArgsConstructor
@Slf4j
public class DefaultDogHubNavigator implements DogHubNavigator {

    private final DogHubDestinationProvider destinationProvider;

    @Override
    public void navigateToLandingPage(@NotNull WebDriver webDriver) {
        navigateTo(webDriver, "landing", destinationProvider.getLandingPage());
    }

    @Override
    public void navigateToSiteHomeView(@NotNull WebDriver webDriver) {
        navigateTo(webDriver, SiteHomeView.NAME, destinationProvider.getSiteHomeView());
    }

    @Override
    public void navigateToAdoptionView(@NotNull WebDriver webDriver) {
        navigateTo(webDriver, AdoptionView.NAME, destinationProvider.getAdoptionView());
    }

    @Override
    public void navigateToTrainingView(@NotNull WebDriver webDriver) {
        navigateTo(webDriver, TrainingView.NAME, destinationProvider.getTrainingView());
    }

    @Override
    public void navigateToKnowledgeView(@NotNull WebDriver webDriver) {
        navigateTo(webDriver, KnowledgeView.NAME, destinationProvider.getKnowledgeView());
    }

    @Override
    public void navigateToSafetyView(@NotNull WebDriver webDriver) {
        navigateTo(webDriver, SafetyView.NAME, destinationProvider.getSafetyView());
    }

    @Override
    public void navigateToSocialView(@NotNull WebDriver webDriver) {
        navigateTo(webDriver, SocialView.NAME, destinationProvider.getSocialView());
    }

    @Override
    public void navigateToStoreView(@NotNull WebDriver webDriver) {
        navigateTo(webDriver, StoreView.NAME, destinationProvider.getStoreView());
    }

    @Override
    public void navigateToPlaydateView(@NotNull WebDriver webDriver) {
        navigateTo(webDriver, PlaydateView.NAME, destinationProvider.getPlaydateView());
    }

    @Override
    public void navigateToBeautyView(@NotNull WebDriver webDriver) {
        navigateTo(webDriver, BeautyView.NAME, destinationProvider.getBeautyView());
    }

    @Override
    public void navigateToHealthView(@NotNull WebDriver webDriver) {
        navigateTo(webDriver, HealthView.NAME, destinationProvider.getHealthView());
    }

    @Override
    public void navigateToLoginView(@NotNull WebDriver webDriver) {
        navigateTo(webDriver, LoginView.NAME, destinationProvider.getLoginView());
    }

    @Override
    public void navigateToSignupView(@NotNull WebDriver webDriver) {
        navigateTo(webDriver, SignupView.NAME, destinationProvider.getSignupView());
    }

    private void navigateTo(@NotNull WebDriver webDriver, @NotNull @NotBlank String pageName, @NotNull URI uri) {
        log.info("Navigate to '{}' started", pageName);
        String currentUrl = webDriver.getCurrentUrl();
        String destination = uri.toString();
        if(currentUrl.equals(destination)) {
            log.info("Destination is equal to current url");
        }
        else {
            webDriver.get(uri.toString());
        }
        log.info("Navigate to '{}' completed", pageName);
    }
}
