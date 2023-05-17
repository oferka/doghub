package org.hk.doghub.ui.components.shared;

import com.vaadin.flow.component.orderedlayout.HorizontalLayout;

public class OrDivider extends HorizontalLayout {

    public static final String CLASS_NAME = "or-divider";

    private final OrDividerLinePart left;

    private final OrDividerText text;

    private final OrDividerLinePart right;

    public OrDivider() {
        addClassName(CLASS_NAME);

        setSpacing(false);

        left = new OrDividerLinePart();
        add(left);

        text = new OrDividerText();
        add(text);

        right = new OrDividerLinePart();
        add(right);
    }
}
