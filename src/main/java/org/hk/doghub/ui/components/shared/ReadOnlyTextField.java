package org.hk.doghub.ui.components.shared;

import com.vaadin.flow.component.Component;

public class ReadOnlyTextField extends DogHubTextField {

    public static final String CLASS_NAME = "read-only-text-field";

    public ReadOnlyTextField(String label, boolean required, int minLength, int maxLength, Component prefixComponent) {
        super(label, required, true, minLength, maxLength, prefixComponent, null);
        addClassName(CLASS_NAME);
    }
}
