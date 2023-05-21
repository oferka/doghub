package org.hk.doghub.automation.e2e.selenium.ui.actions.file.upload;

import jakarta.validation.constraints.NotNull;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import java.io.File;

public interface FileUploadExecutor {

    void upload(@NotNull WebDriver webDriver, @NotNull By inputLocator, @NotNull File fileToBeUploaded);
}
