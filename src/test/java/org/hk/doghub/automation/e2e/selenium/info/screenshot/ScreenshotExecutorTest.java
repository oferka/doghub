package org.hk.doghub.automation.e2e.selenium.info.screenshot;

import org.hk.doghub.automation.e2e.selenium.BaseTest;
import org.hk.doghub.automation.e2e.selenium.Setup;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.EnumSource;
import org.springframework.beans.factory.annotation.Autowired;

class ScreenshotExecutorTest extends BaseTest {

    @Autowired
    private ScreenshotExecutor screenshotExecutor;

    @ParameterizedTest
    @EnumSource(Setup.class)
    public void shouldExecute(Setup setup) {
        initiateWebDriverAndNavigateToTestPage(setup);
        screenshotExecutor.execute(webDriver);
    }

    @ParameterizedTest
    @EnumSource(Setup.class)
    public void shouldExecuteWithCondition(Setup setup) {
        initiateWebDriverAndNavigateToTestPage(setup);
        screenshotExecutor.execute(webDriver, true);
    }
}