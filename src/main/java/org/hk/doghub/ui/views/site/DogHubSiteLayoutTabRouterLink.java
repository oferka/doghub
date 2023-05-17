package org.hk.doghub.ui.views.site;

import com.vaadin.flow.component.Component;
import com.vaadin.flow.router.RouterLink;

import static java.lang.String.format;

public class DogHubSiteLayoutTabRouterLink extends RouterLink {

    public static final String CLASS_NAME = DogHubSiteLayoutTab.CLASS_NAME + "-router-link";

    public  DogHubSiteLayoutTabRouterLink(String text, Class<? extends Component> navigationTarget) {
        super(text, navigationTarget);
        addClassName(CLASS_NAME);
        setId(format("%s-%s", CLASS_NAME, text));
    }
}
