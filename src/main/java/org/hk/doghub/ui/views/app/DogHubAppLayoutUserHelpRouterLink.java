package org.hk.doghub.ui.views.app;

import com.vaadin.flow.router.RouterLink;
import org.hk.doghub.ui.views.site.help.HelpView;

import static org.apache.commons.lang3.StringUtils.EMPTY;

public class DogHubAppLayoutUserHelpRouterLink extends RouterLink {

    public static final String CLASS_NAME = DogHubAppLayoutHeader.CLASS_NAME + "-user-help-router-link";

    private final DogHubAppLayoutUserHelpButton helpButton;

    public DogHubAppLayoutUserHelpRouterLink() {
        super(EMPTY, HelpView.class);
        addClassName(CLASS_NAME);

        helpButton = new DogHubAppLayoutUserHelpButton();
        add(helpButton);
    }
}
