package org.hk.doghub.ui.components.shared;

import com.vaadin.flow.component.icon.VaadinIcon;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;

public class FeedbackAttributeContainer extends HorizontalLayout {

    public static final String CLASS_NAME = "feedback-attribute-container";

    public FeedbackAttributeContainer(VaadinIcon vaadinIcon, Long counter) {
        addClassName(CLASS_NAME);
        FeedbackAttributeIcon icon = new FeedbackAttributeIcon(vaadinIcon);
        FeedbackAttributeCounterLabel counterLabel = new FeedbackAttributeCounterLabel(counter);
        add(icon, counterLabel);
    }
}
