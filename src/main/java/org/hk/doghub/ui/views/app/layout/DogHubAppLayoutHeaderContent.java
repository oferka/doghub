package org.hk.doghub.ui.views.app.layout;

import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import jakarta.validation.constraints.NotNull;

import static com.vaadin.flow.component.orderedlayout.FlexComponent.Alignment.CENTER;

public class DogHubAppLayoutHeaderContent extends HorizontalLayout {

    public static final String CLASS_NAME = DogHubAppLayoutHeader.CLASS_NAME + "-content";

    private final DogHubAppLayoutHeaderContentDrawerToggle toggle;
    private final DogHubAppLayoutHeaderContentTitle title;

    public DogHubAppLayoutHeaderContent() {
        addClassName(CLASS_NAME);
        setSpacing(false);
        setAlignItems(CENTER);

        toggle = new DogHubAppLayoutHeaderContentDrawerToggle();
        add(toggle);

        title = new DogHubAppLayoutHeaderContentTitle();
        add(title);
    }

    public void setTitleText(@NotNull String titleText) {
        title.setTitleText(titleText);
    }
}
