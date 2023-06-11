package org.hk.doghub.ui.components.shared;

public class LikesCounterLabel extends FeedbackAttributeCounterLabel {

    public static final String CLASS_NAME = "likes-counter-label";

    public LikesCounterLabel(Long likesCounter) {
        super(likesCounter);
        addClassName(CLASS_NAME);
    }
}
