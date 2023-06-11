package org.hk.doghub.ui.components.shared;

import static com.vaadin.flow.component.icon.VaadinIcon.COMMENT_O;

public class CommentsIcon extends FeedbackAttributeIcon {

    public static final String CLASS_NAME = "comments-icon";

    public CommentsIcon() {
        super(COMMENT_O);
        addClassName(CLASS_NAME);
    }
}
