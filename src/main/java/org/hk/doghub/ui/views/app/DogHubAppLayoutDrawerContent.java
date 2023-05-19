package org.hk.doghub.ui.views.app;

import com.vaadin.flow.component.orderedlayout.Scroller;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.server.auth.AccessAnnotationChecker;

public class DogHubAppLayoutDrawerContent extends VerticalLayout {

    public static final String CLASS_NAME = DogHubAppLayoutDrawer.CLASS_NAME + "-content";

    private final DogHubAppLayoutDrawerContentNavigation navigation;

    public DogHubAppLayoutDrawerContent(AccessAnnotationChecker accessChecker) {
        addClassName(CLASS_NAME);

        navigation = new DogHubAppLayoutDrawerContentNavigation(accessChecker);
        add(new Scroller(navigation));
    }
}
