package org.hk.doghub.ui.views.app.layout;

import com.vaadin.flow.router.RouterLink;
import jakarta.validation.constraints.NotNull;
import org.hk.doghub.ui.views.site.help.HelpView;

import static org.apache.commons.lang3.StringUtils.EMPTY;

public class HelpRouterLink extends RouterLink {

    public static final String CLASS_NAME = "help-router-link";

    public HelpRouterLink(@NotNull String text) {
        super(EMPTY, HelpView.class);
        addClassName(CLASS_NAME);
        HelpButton help = new HelpButton(text);
        add(help);
    }
}
