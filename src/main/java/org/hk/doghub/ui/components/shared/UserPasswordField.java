package org.hk.doghub.ui.components.shared;

import com.vaadin.flow.component.textfield.PasswordField;

public class UserPasswordField extends PasswordField {

    public static final String CLASS_NAME = "user-password-field";

    public UserPasswordField() {
        addClassName(CLASS_NAME);
        setPlaceholder("Password");
        setHelperText("Password must be at least 8 characters, with at least one letter and one digit.");
        setPattern("^(?=.*[0-9])(?=.*[a-zA-Z]).{8}.*$");
        setErrorMessage("Invalid password");
    }
}
