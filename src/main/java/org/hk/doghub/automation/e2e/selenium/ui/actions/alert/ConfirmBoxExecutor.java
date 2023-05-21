package org.hk.doghub.automation.e2e.selenium.ui.actions.alert;

import jakarta.validation.constraints.NotNull;
import org.openqa.selenium.WebDriver;

public interface ConfirmBoxExecutor {

    void accept(@NotNull WebDriver webDriver);

    void dismiss(@NotNull WebDriver webDriver);
}
