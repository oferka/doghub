package org.hk.doghub.automation.e2e.selenium.ui.actions.popup;

import org.hk.doghub.automation.e2e.selenium.BaseTest;
import org.hk.doghub.automation.e2e.selenium.Setup;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.EnumSource;
import org.springframework.beans.factory.annotation.Autowired;

class PopupRemoverTest extends BaseTest {

    @Autowired
    private PopupRemover popupRemover;

    @ParameterizedTest
    @EnumSource(Setup.class)
    public void shouldRemove(Setup setup) {
        initiateWebDriverAndNavigateToTestPage(setup);
        popupRemover.remove(webDriver);
    }
}