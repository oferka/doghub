package org.hk.doghub.ui.components.shared;

import com.vaadin.flow.component.Component;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;

public class FeedbackAttributeContainer extends HorizontalLayout {

    public static final String CLASS_NAME = "feedback-attribute-container";

    public FeedbackAttributeContainer(Component icon, Long counter) {
        addClassName(CLASS_NAME);
        icon.addClassName("feedback-attribute-icon");
        FeedbackAttributeCounterLabel counterLabel = new FeedbackAttributeCounterLabel(counter);
        add(icon, counterLabel);
    }
}
