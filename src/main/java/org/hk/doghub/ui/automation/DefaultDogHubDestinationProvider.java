package org.hk.doghub.ui.automation;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.hk.doghub.ui.views.site.adoption.AdoptionView;
import org.hk.doghub.ui.views.site.beauty.BeautyView;
import org.hk.doghub.ui.views.site.health.HealthView;
import org.hk.doghub.ui.views.site.home.SiteHomeView;
import org.hk.doghub.ui.views.site.knowledge.KnowledgeView;
import org.hk.doghub.ui.views.site.playdate.PlaydateView;
import org.hk.doghub.ui.views.site.safety.SafetyView;
import org.hk.doghub.ui.views.site.social.SocialView;
import org.hk.doghub.ui.views.site.store.StoreView;
import org.hk.doghub.ui.views.site.training.TrainingView;
import org.springframework.stereotype.Service;
import org.springframework.web.util.UriComponents;

import java.net.URI;

@Service
@Slf4j
@RequiredArgsConstructor
public class DefaultDogHubDestinationProvider implements DogHubDestinationProvider {

    private final DogHubUriComponentsProvider dogHubUriComponentsProvider;

    @Override
    public URI getLandingPage() {
        return getPageURI(SiteHomeView.ROUTE, SiteHomeView.NAME);
    }

    public URI getSiteHomeView() {
        return getPageURI(SiteHomeView.ROUTE, SiteHomeView.NAME);
    }

    public URI getAdoptionView() {
        return getPageURI(AdoptionView.ROUTE, AdoptionView.NAME);
    }

    public URI getTrainingView() {
        return getPageURI(TrainingView.ROUTE, TrainingView.NAME);
    }

    public URI getKnowledgeView() {
        return getPageURI(KnowledgeView.ROUTE, KnowledgeView.NAME);
    }

    @Override
    public URI getSafetyView() {
        return getPageURI(SafetyView.ROUTE, SafetyView.NAME);
    }

    @Override
    public URI getSocialView() {
        return getPageURI(SocialView.ROUTE, SocialView.NAME);
    }

    @Override
    public URI getStoreView() {
        return getPageURI(StoreView.ROUTE, StoreView.NAME);
    }

    @Override
    public URI getPlaydateView() {
        return getPageURI(PlaydateView.ROUTE, PlaydateView.NAME);
    }

    @Override
    public URI getBeautyView() {
        return getPageURI(BeautyView.ROUTE, BeautyView.NAME);
    }

    @Override
    public URI getHealthView() {
        return getPageURI(HealthView.ROUTE, HealthView.NAME);
    }

    private URI getPageURI(String pageRoute, String pageTitle) {
        log.info("Get URI for '{}' page started", pageTitle);
        UriComponents uriComponents = dogHubUriComponentsProvider.get(pageRoute);
        URI result = uriComponents.toUri();
        log.info("Get URI for '{}' page completed", pageTitle);
        return result;
    }
}
