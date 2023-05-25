package org.hk.doghub.ui.views.app.layout;

import com.vaadin.flow.router.RouterLink;
import org.hk.doghub.ui.views.site.settings.SettingsView;

import static org.apache.commons.lang3.StringUtils.EMPTY;

public class DogHubAppLayoutUserSettingsRouterLink extends RouterLink {

    public static final String CLASS_NAME = DogHubAppLayoutHeader.CLASS_NAME + "-user-settings-router-link";

    private final DogHubAppLayoutUserSettingsButton settings;

    public DogHubAppLayoutUserSettingsRouterLink() {
        super(EMPTY, SettingsView.class);
        addClassName(CLASS_NAME);

        settings = new DogHubAppLayoutUserSettingsButton();
        add(settings);
    }
}
