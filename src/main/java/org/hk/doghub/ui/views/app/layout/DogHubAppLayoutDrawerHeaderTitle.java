package org.hk.doghub.ui.views.app.layout;

import com.vaadin.flow.component.html.H1;

import static org.hk.doghub.DogHubApplication.APPLICATION_SHORT_NAME;

public class DogHubAppLayoutDrawerHeaderTitle extends H1 {

    public static final String CLASS_NAME = DogHubAppLayoutDrawerHeader.CLASS_NAME + "-title";

    public DogHubAppLayoutDrawerHeaderTitle() {
        addClassName(CLASS_NAME);
        setText(APPLICATION_SHORT_NAME);
    }
}
