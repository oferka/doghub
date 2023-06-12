package org.hk.doghub.ui.components.shared;

import com.vaadin.flow.component.orderedlayout.HorizontalLayout;

public class OrDivider extends HorizontalLayout {

    public static final String CLASS_NAME = "or-divider";

    public OrDivider() {
        addClassName(CLASS_NAME);
        setSpacing(false);
        OrDividerLinePart left = new OrDividerLinePart();
        OrDividerText text = new OrDividerText();
        OrDividerLinePart right = new OrDividerLinePart();
        add(left, text, right);
    }
}
