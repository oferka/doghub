package org.hk.doghub.ui.components.shared.user;

import com.vaadin.flow.component.textfield.PasswordField;

public class UserPasswordField extends PasswordField {

    public static final String CLASS_NAME = "user-password-field";
    private final static String LABEL = "Password";

    public static final String ERROR_MESSAGE = "Password must be at least 8 characters, with at least one letter and one digit";

    public UserPasswordField() {
        addClassName(CLASS_NAME);
        setPlaceholder(LABEL);
        setMaxLength(64);
        setHelperText(ERROR_MESSAGE);
        setPattern("^(?=.*[0-9])(?=.*[a-zA-Z]).{8}.*$");
        setErrorMessage("Invalid password");
    }
}
