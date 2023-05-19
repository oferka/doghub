package org.hk.doghub.ui.views.app;

import com.vaadin.flow.component.html.Footer;
import com.vaadin.flow.component.html.H3;

public class DogHubAppLayoutDrawerFooter extends Footer {

    public static final String CLASS_NAME = DogHubAppLayoutDrawer.CLASS_NAME + "-footer";

    public DogHubAppLayoutDrawerFooter() {
        addClassName(CLASS_NAME);
        add(new H3("Drawer Footer"));
    }
}
