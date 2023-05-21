package org.hk.doghub.automation.e2e.selenium.ui.actions.file.upload;

import jakarta.validation.constraints.NotNull;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.hk.doghub.automation.e2e.selenium.ui.actions.text.input.TextInputExecutor;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.springframework.stereotype.Service;

import java.io.File;

@Service
@RequiredArgsConstructor
@Slf4j
public class DefaultFileUploadExecutor implements FileUploadExecutor {

    private final TextInputExecutor textInputExecutor;

    @Override
    public void upload(@NotNull WebDriver webDriver, @NotNull By inputLocator, @NotNull File fileToBeUploaded) {
        log.info("Upload file '{}' started", fileToBeUploaded.getName());
        textInputExecutor.enterText(webDriver, inputLocator, fileToBeUploaded.getPath(), false, false);
        log.info("Upload file '{}' completed", fileToBeUploaded.getName());
    }
}
