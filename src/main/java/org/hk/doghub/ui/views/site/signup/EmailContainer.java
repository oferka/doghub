package org.hk.doghub.ui.views.site.signup;

import com.vaadin.flow.component.textfield.EmailField;

public class EmailContainer extends EmailField {

    public static final String CLASS_NAME = SignupWithEmail.CLASS_NAME + "-email-container";

    public EmailContainer() {
        addClassName(CLASS_NAME);
        setPlaceholder("Email");
        getElement().setAttribute("name", "email");
        setErrorMessage("Enter a valid email address");
        setClearButtonVisible(true);
    }
}
