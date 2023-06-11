package org.hk.doghub.ui.components.shared;

import com.vaadin.flow.component.html.Span;

public class FeedbackAttributeCounterLabel extends Span {

    public static final String CLASS_NAME = "feedback-attribute-counter-label";

    public FeedbackAttributeCounterLabel(Long counter) {
        super(counter.toString());
        addClassName(CLASS_NAME);
    }
}
