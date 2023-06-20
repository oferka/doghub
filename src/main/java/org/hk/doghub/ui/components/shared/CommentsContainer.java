package org.hk.doghub.ui.components.shared;

import static org.vaadin.lineawesome.LineAwesomeIcon.COMMENT;

public class CommentsContainer extends FeedbackAttributeContainer {

    public static final String CLASS_NAME = "comments-container";

    public CommentsContainer(Long comments) {
        super(COMMENT.create(), comments);
        addClassName(CLASS_NAME);
    }
}
