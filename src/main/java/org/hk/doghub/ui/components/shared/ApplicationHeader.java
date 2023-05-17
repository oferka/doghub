package org.hk.doghub.ui.components.shared;

import com.vaadin.flow.component.orderedlayout.VerticalLayout;

import static com.vaadin.flow.component.orderedlayout.FlexComponent.Alignment.CENTER;

public class ApplicationHeader extends VerticalLayout {

    public static final String CLASS_NAME = "application-header";

    private final ApplicationHeaderLogo logo;

    private final ApplicationHeaderSlogan slogan;

    public ApplicationHeader() {
        addClassName(CLASS_NAME);

        setAlignItems(CENTER);

        logo = new ApplicationHeaderLogo();
        add(logo);

        slogan = new ApplicationHeaderSlogan();
        add(slogan);
    }
}
