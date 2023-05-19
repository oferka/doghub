package org.hk.doghub.ui.views.app;

import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.server.auth.AccessAnnotationChecker;

import static com.vaadin.flow.component.orderedlayout.FlexComponent.Alignment.STRETCH;

public class DogHubAppLayoutDrawer extends VerticalLayout {

    public static final String CLASS_NAME = DogHubAppLayout.ID + "-drawer";

    private final DogHubAppLayoutDrawerHeader header;
    private final DogHubAppLayoutDrawerContent content;
    private final DogHubAppLayoutDrawerFooter footer;

    public DogHubAppLayoutDrawer(AccessAnnotationChecker accessChecker) {
        addClassName(CLASS_NAME);
        getThemeList().set("dark", true);
        setSizeFull();
        setPadding(false);
        setSpacing(false);
        setAlignItems(STRETCH);
        header = new DogHubAppLayoutDrawerHeader();
        content = new DogHubAppLayoutDrawerContent(accessChecker);
        footer = new DogHubAppLayoutDrawerFooter();
        add(header, content, footer);
    }
}
