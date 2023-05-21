package org.hk.doghub.automation.e2e.selenium.page;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.springframework.stereotype.Service;

import java.time.Duration;

@Service
@RequiredArgsConstructor
@Slf4j
public class DefaultTitleVerifier implements TitleVerifier {

    private final TitleVerifierConfiguration titleVerifierConfiguration;

    @Override
    public void verifyEquals(@NotNull WebDriver webDriver, @NotNull @NotBlank String title) {
        log.info("Verify that page title is '{}' started", title);
        new WebDriverWait(
                webDriver,
                Duration.ofSeconds(titleVerifierConfiguration.getTimeOutInSeconds()))
                .until(ExpectedConditions.titleIs(title));
        log.info("Verify that page title is '{}' completed successfully", title);
    }

    @Override
    public void verifyContains(@NotNull WebDriver webDriver, @NotNull @NotBlank String title) {
        log.info("Verify that page title contains '{}' started", title);
        new WebDriverWait(
                webDriver,
                Duration.ofSeconds(titleVerifierConfiguration.getTimeOutInSeconds()))
                .until(ExpectedConditions.titleContains(title));
        log.info("Verify that page title contains '{}' completed successfully", title);
    }
}
