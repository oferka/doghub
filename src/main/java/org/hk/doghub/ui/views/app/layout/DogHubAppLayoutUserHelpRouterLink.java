package org.hk.doghub.ui.views.app.layout;

import com.vaadin.flow.router.RouterLink;
import org.hk.doghub.ui.views.site.help.HelpView;

import static org.apache.commons.lang3.StringUtils.EMPTY;

public class DogHubAppLayoutUserHelpRouterLink extends RouterLink {

    public static final String CLASS_NAME = DogHubAppLayoutHeader.CLASS_NAME + "-user-help-router-link";

    public DogHubAppLayoutUserHelpRouterLink() {
        super(EMPTY, HelpView.class);
        addClassName(CLASS_NAME);
        DogHubAppLayoutUserHelpButton help = new DogHubAppLayoutUserHelpButton();
        add(help);
    }
}
