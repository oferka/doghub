package org.hk.doghub.ui.views.app;

import com.vaadin.flow.component.applayout.DrawerToggle;
import com.vaadin.flow.component.button.ButtonVariant;

public class DogHubAppLayoutHeaderContentDrawerToggle extends DrawerToggle {

    public static final String CLASS_NAME = DogHubAppLayoutHeaderContent.CLASS_NAME + "-drawer-toggle";

    public DogHubAppLayoutHeaderContentDrawerToggle() {
        addClassName(CLASS_NAME);
        addThemeVariants(ButtonVariant.LUMO_CONTRAST);
        getElement().setAttribute("aria-label", "Menu toggle");
    }
}
