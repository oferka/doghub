package org.hk.doghub.ui.components.shared;

import static com.vaadin.flow.component.icon.VaadinIcon.SHARE_SQUARE;

public class SharesContainer extends FeedbackAttributeContainer {

    public static final String CLASS_NAME = "shares-container";

    public SharesContainer(Long shares) {
        super(SHARE_SQUARE, shares);
        addClassName(CLASS_NAME);
    }
}
