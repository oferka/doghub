package org.hk.doghub.ui.views.app.layout;

import com.vaadin.flow.router.RouterLink;
import jakarta.validation.constraints.NotNull;
import org.hk.doghub.ui.views.site.help.HelpView;

public class HelpRouterLink extends RouterLink {

    public static final String CLASS_NAME = "help-router-link";

    public HelpRouterLink(@NotNull String text) {
        super(text, HelpView.class);
        addClassName(CLASS_NAME);
        HelpButton help = new HelpButton();
        add(help);
    }
}
