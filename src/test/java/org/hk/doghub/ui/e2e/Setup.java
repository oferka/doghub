package org.hk.doghub.ui.e2e;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;
import org.hk.doghub.automation.e2e.selenium.browser.Browser;
import org.hk.doghub.automation.e2e.selenium.browser.BrowserConfiguration;

@AllArgsConstructor
@ToString
public enum Setup {

    SETUP_1("setup 1", new BrowserConfiguration(Browser.BrowserType.CHROME, true, false)),
//    SETUP_2("setup 2", new BrowserConfiguration(Browser.BrowserType.CHROME, true, true)),
//    SETUP_3("setup 3", new BrowserConfiguration(Browser.BrowserType.CHROME, false, false)),
//    SETUP_4("setup 4", new BrowserConfiguration(Browser.BrowserType.CHROME, false, true)),
    SETUP_5("setup 5", new BrowserConfiguration(Browser.BrowserType.FIREFOX, true, false)),
//    SETUP_6("setup 6", new BrowserConfiguration(Browser.BrowserType.FIREFOX, true, true)),
//    SETUP_7("setup 7", new BrowserConfiguration(Browser.BrowserType.FIREFOX, false, false)),
//    SETUP_8("setup 8", new BrowserConfiguration(Browser.BrowserType.FIREFOX, false, true)),
//    SETUP_9("setup 9", new BrowserConfiguration(Browser.BrowserType.EDGE, true, false)),
//    SETUP_10("setup 10", new BrowserConfiguration(Browser.BrowserType.EDGE, false, true)),
    SETUP_11("setup 11", new BrowserConfiguration(Browser.BrowserType.SAFARI, true, false));
//    SETUP_12("setup 12", new BrowserConfiguration(Browser.BrowserType.SAFARI, false, false));

    @Getter
    @NotNull
    @Size(min = 2, max = 16)
    @NotBlank
    private final String name;

    @Getter
    @NotNull
    private final BrowserConfiguration browserConfiguration;
}
