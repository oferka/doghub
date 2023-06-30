package org.hk.doghub.ui.views.app.layout;

import com.vaadin.flow.router.RouterLink;
import jakarta.validation.constraints.NotNull;
import org.hk.doghub.ui.views.site.settings.SettingsView;

import static org.apache.commons.lang3.StringUtils.EMPTY;

public class SettingsRouterLink extends RouterLink {

    public static final String CLASS_NAME = "settings-router-link";

    public SettingsRouterLink(@NotNull String text) {
        super(EMPTY, SettingsView.class);
        addClassName(CLASS_NAME);
        SettingsButton settings = new SettingsButton(text);
        add(settings);
    }
}
