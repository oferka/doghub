package org.hk.doghub.automation.e2e.selenium.info.screenshot;

import jakarta.validation.constraints.NotNull;
import org.openqa.selenium.WebDriver;

public interface ScreenshotExecutor {

    void execute(@NotNull WebDriver webDriver);

    void execute(@NotNull WebDriver webDriver, boolean condition);
}
