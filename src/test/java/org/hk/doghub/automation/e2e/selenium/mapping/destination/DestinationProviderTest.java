package org.hk.doghub.automation.e2e.selenium.mapping.destination;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.net.URI;

@SpringBootTest
@Slf4j
class DestinationProviderTest {

    @Autowired
    private DestinationProvider destinationProvider;

    @Test
    public void shouldGetLandingPage() {
        URI landingPage = destinationProvider.getLandingPage();
        log.info("Landing page URI is: {}", landingPage);
        Assertions.assertNotNull(landingPage);
    }

    @Test
    public void shouldGetSignupLoginPage() {
        URI signupLoginPage = destinationProvider.getSignupLoginPage();
        log.info("Signup-Login page URI is: {}", signupLoginPage);
        Assertions.assertNotNull(signupLoginPage);
    }
}