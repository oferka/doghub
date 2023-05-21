package org.hk.doghub.automation.e2e.selenium.browser;

import org.hk.doghub.automation.e2e.selenium.Setup;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.EnumSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertNotNull;

@SpringBootTest
class BrowserProviderTest {

    @Autowired
    private BrowserProvider browserProvider;

    @Test
    public void shouldGet() {
        Browser browser = browserProvider.get();
        assertNotNull(browser);
    }

    @ParameterizedTest
    @EnumSource(Setup.class)
    public void shouldGetWithSpecifiedConfiguration(Setup setup) {
        Browser browser = browserProvider.get(setup.getBrowserConfiguration());
        assertNotNull(browser);
    }
}