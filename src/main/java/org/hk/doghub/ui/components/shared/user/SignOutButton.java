package org.hk.doghub.ui.components.shared.user;

import com.vaadin.flow.component.button.Button;
import org.hk.doghub.security.AuthenticatedUser;

import static org.vaadin.lineawesome.LineAwesomeIcon.SIGN_OUT_ALT_SOLID;

public class SignOutButton extends Button {

    public static final String CLASS_NAME = "sign-out-button";

    public SignOutButton(AuthenticatedUser authenticatedUser) {
        addClassName(CLASS_NAME);
        setIcon(SIGN_OUT_ALT_SOLID.create());
        setText("Sign out");
        addClickListener(e -> authenticatedUser.logout());
    }
}
