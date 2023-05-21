package org.hk.doghub.automation.e2e.selenium.browser;

import jakarta.validation.constraints.NotNull;

public interface BrowserProvider {

    @NotNull Browser get();

    @NotNull Browser get(BrowserConfiguration configuration);
}
