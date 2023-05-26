package org.hk.doghub.ui.components.shared;

import com.vaadin.flow.component.textfield.EmailField;

public class UserEmailField extends EmailField {

    public static final String CLASS_NAME = "user-email-field";

    public UserEmailField() {
        addClassName(CLASS_NAME);
        setPlaceholder("Email");
        getElement().setAttribute("name", "email");
        setErrorMessage("Enter a valid email address");
        setClearButtonVisible(true);
    }
}
