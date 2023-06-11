package org.hk.doghub.ui.components.shared;

import com.vaadin.flow.component.icon.VaadinIcon;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;

public class FeedbackAttributeContainer extends HorizontalLayout {

    public static final String CLASS_NAME = "feedback-attribute-container";

    private final FeedbackAttributeIcon icon;

    private final FeedbackAttributeCounterLabel counterLabel;

    public FeedbackAttributeContainer(VaadinIcon vaadinIcon, Long counter) {
        addClassName(CLASS_NAME);

        icon = new FeedbackAttributeIcon(vaadinIcon);
        add(icon);

        counterLabel = new FeedbackAttributeCounterLabel(counter);
        add(counterLabel);
    }
}
