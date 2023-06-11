package org.hk.doghub.ui.components.shared;

import com.vaadin.flow.component.html.Span;

public class LikesCounterLabel extends Span {

    public static final String CLASS_NAME = "likes-counter-label";

    public LikesCounterLabel(Long likesCounter) {
        super(likesCounter.toString());
        addClassName(CLASS_NAME);
    }
}
