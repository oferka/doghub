package org.hk.doghub.ui.components.shared;

import com.vaadin.flow.component.Component;

public class EditableTextField extends DogHubTextField {

    public static final String CLASS_NAME = "editable-text-field";

    public EditableTextField(String label, boolean required, int maxLength, Component prefixComponent, String allowedCharPattern) {
        super(label, required, false, maxLength, prefixComponent, allowedCharPattern);
        addClassName(CLASS_NAME);
    }
}
