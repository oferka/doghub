package org.hk.doghub.automation.e2e.selenium.ui.actions.click;

import org.hk.doghub.automation.e2e.selenium.BaseTest;
import org.hk.doghub.automation.e2e.selenium.Setup;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.EnumSource;
import org.springframework.beans.factory.annotation.Autowired;

class ClickSoundPlayerTest extends BaseTest {

    @Autowired
    private ClickSoundPlayer clickSoundPlayer;

    @ParameterizedTest
    @EnumSource(Setup.class)
    public void shouldPlay(Setup setup) {
        initiateWebDriverAndNavigateToTestPage(setup);
        clickSoundPlayer.play();
    }
}