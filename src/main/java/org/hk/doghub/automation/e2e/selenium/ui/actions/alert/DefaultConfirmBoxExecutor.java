package org.hk.doghub.automation.e2e.selenium.ui.actions.alert;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.ToString;
import lombok.extern.slf4j.Slf4j;
import org.hk.doghub.automation.e2e.selenium.ui.actions.pause.PauseExecutor;
import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.springframework.stereotype.Service;

import java.time.Duration;

@Service
@Slf4j
@RequiredArgsConstructor
public class DefaultConfirmBoxExecutor implements ConfirmBoxExecutor {

    private final ConfirmBoxExecutorConfiguration confirmBoxExecutorConfiguration;

    private final ConfirmBoxSoundPlayer confirmBoxSoundPlayer;

    private final PauseExecutor pauseExecutor;

    @Override
    public void accept(@NotNull WebDriver webDriver) {
        execute(webDriver, ConfirmBoxAction.ACCEPT);
    }

    @Override
    public void dismiss(@NotNull WebDriver webDriver) {
        execute(webDriver, ConfirmBoxAction.DISMISS);
    }

    private void execute(@NotNull WebDriver webDriver, ConfirmBoxAction confirmBoxAction) {
        log.info("{} confirm box started", confirmBoxAction.getName());
        pauseExecutor.pause();
        new WebDriverWait(webDriver, Duration.ofSeconds(confirmBoxExecutorConfiguration.getNumberOfSecondsToWaitForAlert())).until(ExpectedConditions.alertIsPresent());
        confirmBoxSoundPlayer.play();
        Alert alert = webDriver.switchTo().alert();
        String confirmBoxText = alert.getText();
        switch (confirmBoxAction) {
            case ACCEPT -> alert.accept();
            case DISMISS -> alert.dismiss();
        }
        pauseExecutor.pause();
        log.info("{} confirm box completed. Confirm bob text was '{}'", confirmBoxAction.getName(), confirmBoxText);
    }

    @AllArgsConstructor
    @ToString
    public enum ConfirmBoxAction {

        ACCEPT("Accept"),
        DISMISS("Dismiss");

        @Getter
        @NotNull
        @Size(min = 2, max = 16)
        @NotBlank
        private final String name;
    }
}
