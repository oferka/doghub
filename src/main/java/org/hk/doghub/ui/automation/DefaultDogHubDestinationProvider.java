package org.hk.doghub.ui.automation;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.hk.doghub.ui.views.site.adoption.AdoptionView;
import org.hk.doghub.ui.views.site.home.SiteHomeView;
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

//    @Override
//    public URI getSignupLoginPage() {
//        return getPageURI(SignupLoginPage.ROUTE, SignupLoginPage.TITLE);
//    }
//
//    @Override
//    public URI getContactUsPage() {
//        return getPageURI(ContactUsPage.ROUTE, ContactUsPage.TITLE);
//    }
//
//    @Override
//    public URI getTestCasesPage() {
//        return getPageURI(TestCasesPage.ROUTE, TestCasesPage.TITLE);
//    }
//
//    @Override
//    public URI getProductsPage() {
//        return getPageURI(ProductsPage.ROUTE, ProductsPage.TITLE);
//    }
//
//    @Override
//    public URI getCartPage() {
//        return getPageURI(CartPage.ROUTE, CartPage.TITLE);
//    }
//
//    @Override
//    public URI getApiTestingPage() {
//        return getPageURI(ApiTestingPage.ROUTE, ApiTestingPage.TITLE);
//    }

    private URI getPageURI(String pageRoute, String pageTitle) {
        log.info("Get URI for '{}' page started", pageTitle);
        UriComponents uriComponents = dogHubUriComponentsProvider.get(pageRoute);
        URI result = uriComponents.toUri();
        log.info("Get URI for '{}' page completed", pageTitle);
        return result;
    }
}
