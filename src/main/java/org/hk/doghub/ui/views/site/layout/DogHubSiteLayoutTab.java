package org.hk.doghub.ui.views.site.layout;

import com.vaadin.flow.component.Component;
import com.vaadin.flow.component.ComponentUtil;
import com.vaadin.flow.component.tabs.Tab;

import static java.lang.String.format;

public class DogHubSiteLayoutTab extends Tab {

    public static final String CLASS_NAME = DogHubSiteLayout.ID + "-tab";

    private final String text;

    public  DogHubSiteLayoutTab(String text, Class<? extends Component> navigationTarget) {
        this.text = text;
        addClassName(CLASS_NAME);
        setId(format("%s-%s", CLASS_NAME, text));
        DogHubSiteLayoutTabRouterLink tabRouterLink = new DogHubSiteLayoutTabRouterLink(text, navigationTarget);
        add(tabRouterLink);
        ComponentUtil.setData(this, Class.class, navigationTarget);
    }

    public String getText() {
        return text;
    }
}
