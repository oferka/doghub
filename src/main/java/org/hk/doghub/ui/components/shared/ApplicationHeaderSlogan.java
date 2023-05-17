package org.hk.doghub.ui.components.shared;

import com.vaadin.flow.component.html.Span;

public class ApplicationHeaderSlogan extends Span {

    public static final String CLASS_NAME = ApplicationHeader.CLASS_NAME + "-slogan";

    public ApplicationHeaderSlogan() {
        addClassName(CLASS_NAME);
        setText("Kinky Web Browsing");
    }
}
