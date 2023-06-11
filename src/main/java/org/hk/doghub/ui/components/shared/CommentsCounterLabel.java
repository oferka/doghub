package org.hk.doghub.ui.components.shared;

public class CommentsCounterLabel extends FeedbackAttributeCounterLabel {

    public static final String CLASS_NAME = "comments-counter-label";

    public CommentsCounterLabel(Long commentsCounter) {
        super(commentsCounter);
        addClassName(CLASS_NAME);
    }
}
