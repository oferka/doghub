package org.hk.doghub.ui.components.shared;

import com.vaadin.flow.component.orderedlayout.VerticalLayout;

import static com.vaadin.flow.component.orderedlayout.FlexComponent.Alignment.CENTER;

public class ApplicationHeader extends VerticalLayout {

    public static final String CLASS_NAME = "application-header";

    public ApplicationHeader() {
        addClassName(CLASS_NAME);
        setAlignItems(CENTER);
        ApplicationHeaderLogo logo = new ApplicationHeaderLogo();
        ApplicationHeaderSlogan slogan = new ApplicationHeaderSlogan();
        add(logo, slogan);
    }
}
