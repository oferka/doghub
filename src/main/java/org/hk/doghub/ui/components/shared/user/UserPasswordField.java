package org.hk.doghub.ui.components.shared.user;

import com.vaadin.flow.component.textfield.PasswordField;

import static java.text.MessageFormat.format;

public class UserPasswordField extends PasswordField {

    public static final String CLASS_NAME = "user-password-field";

    private static String LABEL = "Password";

    public UserPasswordField() {
        addClassName(CLASS_NAME);
        setPlaceholder(LABEL);
        setHelperText(format("{0} must be at least 8 characters, with at least one letter and one digit", LABEL));
        setPattern("^(?=.*[0-9])(?=.*[a-zA-Z]).{8}.*$");
        setErrorMessage("Invalid password");
    }
}