package org.hk.doghub.automation.e2e.selenium.ui.actions.popup;

import jakarta.validation.constraints.NotNull;
import org.openqa.selenium.WebDriver;

public interface PopupRemover {

    void remove(@NotNull WebDriver webDriver);
}
