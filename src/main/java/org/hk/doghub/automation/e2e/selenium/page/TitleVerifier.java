package org.hk.doghub.automation.e2e.selenium.page;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import org.openqa.selenium.WebDriver;

public interface TitleVerifier {

    void verifyEquals(@NotNull WebDriver webDriver, @NotNull @NotBlank String title);

    void verifyContains(@NotNull WebDriver webDriver, @NotNull @NotBlank String title);
}
