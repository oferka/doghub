package org.hk.doghub.ui.views.app.layout;

import com.vaadin.flow.component.orderedlayout.HorizontalLayout;

import static com.vaadin.flow.component.orderedlayout.FlexComponent.Alignment.CENTER;

public class DogHubAppLayoutDrawerHeader extends HorizontalLayout {

    public static final String CLASS_NAME = DogHubAppLayoutDrawer.CLASS_NAME + "-header";

    public DogHubAppLayoutDrawerHeader() {
        addClassName(CLASS_NAME);
        setAlignItems(CENTER);
        DogHubAppLayoutDrawerHeaderImage image = new DogHubAppLayoutDrawerHeaderImage();
        DogHubAppLayoutDrawerHeaderTitle title = new DogHubAppLayoutDrawerHeaderTitle();
        add(image, title);
    }
}
