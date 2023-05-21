package org.hk.doghub.automation.e2e.selenium.ui.actions.pause;

import jakarta.validation.constraints.NotNull;

import java.time.Duration;

public interface PauseExecutor {

    void pause();

    void pause(@NotNull Duration duration);
}
