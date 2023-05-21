package org.hk.doghub.automation.e2e.selenium.ui.actions.pause;

import jakarta.validation.constraints.NotNull;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.time.Duration;

@Service
@Slf4j
@RequiredArgsConstructor
public class DefaultPauseExecutor implements PauseExecutor {

    private final ExecutionPauserConfiguration executionPauserConfiguration;

    @Override
    public void pause() {
        pause(Duration.ofMillis(executionPauserConfiguration.getDefaultDelayInMillis()));
    }

    @Override
    public void pause(@NotNull Duration duration) {
        if(executionPauserConfiguration.isEnabled()) {
            long delayInMillis = duration.toMillis();
            log.debug("Pause execution for '{}' milliseconds started", delayInMillis);
            try {
                Thread.sleep(delayInMillis);
            }
            catch (InterruptedException e) {
                log.error("Failed to pause execution. error message is '{}'", e.getMessage());
            }
            log.debug("Pause execution for '{}' milliseconds completed", delayInMillis);
        }
    }
}
