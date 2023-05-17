package org.hk.doghub.ui.components.shared;

import com.vaadin.flow.component.html.Hr;

public class OrDividerLinePart extends Hr {

    public static final String CLASS_NAME = OrDivider.CLASS_NAME + "-line-part";

    public OrDividerLinePart() {
        addClassName(CLASS_NAME);
    }
}
