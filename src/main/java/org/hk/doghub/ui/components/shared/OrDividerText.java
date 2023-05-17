package org.hk.doghub.ui.components.shared;

import com.vaadin.flow.component.html.Span;

public class OrDividerText extends Span {

    public static final String CLASS_NAME = OrDivider.CLASS_NAME + "-text";

    public OrDividerText() {
        addClassName(CLASS_NAME);
        setText("or");
    }
}
