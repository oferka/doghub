package org.hk.doghub.automation.e2e.selenium.info.screenshot;

import org.hk.doghub.automation.e2e.selenium.BaseTest;
import org.hk.doghub.automation.e2e.selenium.Setup;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.EnumSource;
import org.springframework.beans.factory.annotation.Autowired;

class ScreenshotSoundPlayerTest extends BaseTest {

    @Autowired
    private ScreenshotSoundPlayer screenshotSoundPlayer;

    @ParameterizedTest
    @EnumSource(Setup.class)
    public void shouldPlay(Setup setup) {
        initiateWebDriverAndNavigateToTestPage(setup);
        screenshotSoundPlayer.play();
    }
}