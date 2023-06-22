package org.hk.doghub.ui.automation;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.hk.doghub.ui.views.site.adoption.AdoptionView;
import org.hk.doghub.ui.views.site.home.SiteHomeView;
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
