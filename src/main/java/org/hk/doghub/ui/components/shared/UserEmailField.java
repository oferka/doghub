package org.hk.doghub.ui.components.shared;

import com.vaadin.flow.component.textfield.EmailField;

import static java.text.MessageFormat.format;

public class UserEmailField extends EmailField {

    public static final String CLASS_NAME = "user-email-field";

    public static final String LABEL = "Email";

    public UserEmailField() {
        addClassName(CLASS_NAME);
        setPlaceholder(LABEL);
        getElement().setAttribute("name", "email");
        setErrorMessage(format("Please enter a valid {0} address", LABEL));
        setClearButtonVisible(true);
    }
}
