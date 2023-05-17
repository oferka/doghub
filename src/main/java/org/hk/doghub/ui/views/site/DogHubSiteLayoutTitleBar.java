package org.hk.doghub.ui.views.site;

import com.vaadin.flow.component.orderedlayout.HorizontalLayout;

import static com.vaadin.flow.component.orderedlayout.FlexComponent.Alignment.CENTER;

public class DogHubSiteLayoutTitleBar extends HorizontalLayout {

    public static final String CLASS_NAME = DogHubSiteLayout.ID + "-title-bar";

    private final DogHubSiteLayoutTitleRouterLink titleRouterLink;

    public DogHubSiteLayoutTitleBar() {
        addClassName(CLASS_NAME);
        setAlignItems(CENTER);

        titleRouterLink = new DogHubSiteLayoutTitleRouterLink();
        add(titleRouterLink);
    }
}
