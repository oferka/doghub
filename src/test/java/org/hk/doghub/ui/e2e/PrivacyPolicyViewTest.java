package org.hk.doghub.ui.e2e;

import org.hk.doghub.ui.automation.PrivacyPolicyViewService;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.EnumSource;
import org.springframework.beans.factory.annotation.Autowired;

public class PrivacyPolicyViewTest extends DogHubUITest {

    @Autowired
    private PrivacyPolicyViewService viewService;

    @ParameterizedTest
    @EnumSource(Setup.class)
    public void shouldNavigateDirectly(Setup setup) {
        initiateWebDriverAndNavigateToLandingPage(setup);
        viewService.navigateDirectly(webDriver);
    }
}
