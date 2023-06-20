package org.hk.doghub.ui.components.shared;

import static org.vaadin.lineawesome.LineAwesomeIcon.SHARE_SOLID;

public class SharesContainer extends FeedbackAttributeContainer {

    public static final String CLASS_NAME = "shares-container";

    public SharesContainer(Long shares) {
        super(SHARE_SOLID.create(), shares);
        addClassName(CLASS_NAME);
    }
}
