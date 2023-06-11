package org.hk.doghub.ui.components.shared;

import static com.vaadin.flow.component.icon.VaadinIcon.SHARE_SQUARE;

public class SharesIcon extends FeedbackAttributeIcon {

    public static final String CLASS_NAME = "shares-icon";

    public SharesIcon() {
        super(SHARE_SQUARE);
        addClassName(CLASS_NAME);
    }
}
