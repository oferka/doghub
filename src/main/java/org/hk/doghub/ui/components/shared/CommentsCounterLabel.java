package org.hk.doghub.ui.components.shared;

import com.vaadin.flow.component.html.Span;

public class CommentsCounterLabel extends Span {

    public static final String CLASS_NAME = "comments-counter-label";

    public CommentsCounterLabel(Long commentsCounter) {
        super(commentsCounter.toString());
        addClassName(CLASS_NAME);
    }
}
