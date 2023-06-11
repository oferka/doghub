package org.hk.doghub.ui.components.shared;

import com.vaadin.flow.component.icon.Icon;
import com.vaadin.flow.component.icon.VaadinIcon;

public class FeedbackAttributeIcon extends Icon {

    public static final String CLASS_NAME = "feedback-attribute-icon";

    public FeedbackAttributeIcon(VaadinIcon vaadinIcon) {
        super(vaadinIcon);
        addClassName(CLASS_NAME);
    }
}
