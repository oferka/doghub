package org.hk.doghub.ui.components.shared;

import com.vaadin.flow.component.icon.Icon;

import static com.vaadin.flow.component.icon.VaadinIcon.SHARE_SQUARE;

public class SharesIcon extends Icon {

    public static final String CLASS_NAME = "shares-icon";

    public SharesIcon() {
        super(SHARE_SQUARE);
        addClassName(CLASS_NAME);
    }
}
