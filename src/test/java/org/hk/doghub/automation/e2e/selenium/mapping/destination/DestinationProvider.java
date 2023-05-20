package org.hk.doghub.automation.e2e.selenium.mapping.destination;

import java.net.URI;

public interface DestinationProvider {

    URI getLandingPage();

    URI getSignupLoginPage();

    URI getContactUsPage();

    URI getTestCasesPage();

    URI getProductsPage();

    URI getCartPage();

    URI getApiTestingPage();
}
