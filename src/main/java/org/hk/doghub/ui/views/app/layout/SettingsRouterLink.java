package org.hk.doghub.ui.views.app.layout;

import com.vaadin.flow.router.RouterLink;
import jakarta.validation.constraints.NotNull;
import org.hk.doghub.ui.views.site.settings.SettingsView;

public class SettingsRouterLink extends RouterLink {

    public static final String CLASS_NAME = "settings-router-link";

    public SettingsRouterLink(@NotNull String text) {
        super(text, SettingsView.class);
        addClassName(CLASS_NAME);
        SettingsButton settings = new SettingsButton();
        add(settings);
    }
}
