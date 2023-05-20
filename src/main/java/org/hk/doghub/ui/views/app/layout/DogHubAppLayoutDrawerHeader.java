package org.hk.doghub.ui.views.app.layout;

import com.vaadin.flow.component.orderedlayout.HorizontalLayout;

import static com.vaadin.flow.component.orderedlayout.FlexComponent.Alignment.CENTER;

public class DogHubAppLayoutDrawerHeader extends HorizontalLayout {

    public static final String CLASS_NAME = DogHubAppLayoutDrawer.CLASS_NAME + "-header";

    private final DogHubAppLayoutDrawerHeaderImage image;
    private final DogHubAppLayoutDrawerHeaderTitle title;

    public DogHubAppLayoutDrawerHeader() {
        addClassName(CLASS_NAME);
        setAlignItems(CENTER);

        image = new DogHubAppLayoutDrawerHeaderImage();
        add(image);

        title = new DogHubAppLayoutDrawerHeaderTitle();
        add(title);
    }
}
