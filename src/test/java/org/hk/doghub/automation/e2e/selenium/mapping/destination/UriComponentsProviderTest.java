package org.hk.doghub.automation.e2e.selenium.mapping.destination;

import lombok.extern.slf4j.Slf4j;
import org.hk.doghub.DogHubApplication;
import org.hk.doghub.automation.e2e.selenium.mapping.page.SignupLoginPage;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.web.util.UriComponents;

@SpringBootTest(classes = DogHubApplication.class)
@Slf4j
class UriComponentsProviderTest {

    @Autowired
    private UriComponentsProvider uriComponentsProvider;

    @Test
    public void shouldGet() {
        UriComponents landingPageUriComponents = uriComponentsProvider.get(SignupLoginPage.ROUTE);
        log.info("Landing page URI Components: {}", landingPageUriComponents);
        Assertions.assertNotNull(landingPageUriComponents);
    }

    @Test
    public void shouldGetWithSpecifiedPort() {
        UriComponents landingPageUriComponents = uriComponentsProvider.get(8080, SignupLoginPage.ROUTE);
        log.info("Landing page URI Components: {}", landingPageUriComponents);
        Assertions.assertNotNull(landingPageUriComponents);
    }
}