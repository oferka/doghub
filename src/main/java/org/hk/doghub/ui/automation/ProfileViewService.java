package org.hk.doghub.ui.automation;

import jakarta.validation.constraints.NotNull;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.openqa.selenium.WebDriver;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Slf4j
public class ProfileViewService {

    private final UserMenuBarService userMenuBarService;

    public void navigateFromHomePage(@NotNull WebDriver webDriver) {
        userMenuBarService.navigateToProfileView(webDriver);
    }
}
