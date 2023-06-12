package org.hk.doghub.ui.views.site.layout;

import com.vaadin.flow.component.Component;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import org.hk.doghub.security.AuthenticatedUser;

import static com.vaadin.flow.component.orderedlayout.FlexComponent.Alignment.CENTER;
import static com.vaadin.flow.component.orderedlayout.FlexComponent.JustifyContentMode.BETWEEN;

public class DogHubSiteLayoutHeader extends HorizontalLayout {

    public static final String CLASS_NAME = DogHubSiteLayout.ID + "-header";

    private final DogHubSiteLayoutTabs tabs;

    public DogHubSiteLayoutHeader(AuthenticatedUser authenticatedUser) {
        addClassName(CLASS_NAME);
        setPadding(true);
        setJustifyContentMode(BETWEEN);
        DogHubSiteLayoutTitleBar titleBar = new DogHubSiteLayoutTitleBar();
        add(titleBar);
        tabs = new DogHubSiteLayoutTabs();
        addAndExpand(tabs);
        DogHubSiteLayoutActionsBar actionsBar = new DogHubSiteLayoutActionsBar(authenticatedUser);
        add(actionsBar);
        setVerticalComponentAlignment(CENTER, titleBar, tabs, actionsBar);
    }

    public void presentTab(Component content) {
        tabs.presentTab(content);
    }
}
