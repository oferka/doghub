package org.hk.doghub.automation.e2e.selenium.ui.actions.pause;

import org.hk.doghub.automation.e2e.selenium.BaseTest;
import org.hk.doghub.automation.e2e.selenium.Setup;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.EnumSource;
import org.springframework.beans.factory.annotation.Autowired;

import java.time.Duration;

class PauseExecutorTest extends BaseTest {

    @Autowired
    private PauseExecutor pauseExecutor;

    @ParameterizedTest
    @EnumSource(Setup.class)
    public void shouldPause(Setup setup) {
        initiateWebDriverAndNavigateToTestPage(setup);
        pauseExecutor.pause();
    }

    @ParameterizedTest
    @EnumSource(Setup.class)
    public void shouldPauseForSpecifiedDuration(Setup setup) {
        initiateWebDriverAndNavigateToTestPage(setup);
        pauseExecutor.pause(Duration.ofSeconds(1));
    }
}