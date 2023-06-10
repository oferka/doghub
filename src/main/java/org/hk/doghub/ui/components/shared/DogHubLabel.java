package org.hk.doghub.ui.components.shared;

import com.vaadin.flow.component.html.Span;

public class DogHubLabel extends Span {

    public static final String CLASS_NAME = "dog-hub-label";

    public DogHubLabel(String text) {
        super(text);
        addClassName(CLASS_NAME);
    }
}
