package org.hk.doghub.automation.e2e.selenium.browser;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import org.openqa.selenium.WebDriver;

public interface WebDriverProvider {

    @NotNull WebDriver get(@Valid @NotNull Browser browser);
}
