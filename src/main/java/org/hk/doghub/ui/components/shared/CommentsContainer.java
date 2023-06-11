package org.hk.doghub.ui.components.shared;

import static com.vaadin.flow.component.icon.VaadinIcon.COMMENT_O;

public class CommentsContainer extends FeedbackAttributeContainer {

    public static final String CLASS_NAME = "comments-container";

    public CommentsContainer(Long comments) {
        super(COMMENT_O, comments);
        addClassName(CLASS_NAME);
    }
}
