package org.hk.doghub.ui.components.shared;

import com.vaadin.flow.component.icon.Icon;

import static com.vaadin.flow.component.icon.VaadinIcon.HEART_O;

public class LikesIcon extends Icon {

    public static final String CLASS_NAME = "likes-icon";

    public LikesIcon() {
        super(HEART_O);
        addClassName(CLASS_NAME);
    }
}
