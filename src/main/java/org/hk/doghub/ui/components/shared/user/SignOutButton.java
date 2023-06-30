package org.hk.doghub.ui.components.shared.user;

import com.vaadin.flow.component.button.Button;
import org.hk.doghub.security.AuthenticatedUser;

public class SignOutButton extends Button {

    public static final String CLASS_NAME = "sign-out-button";

    public SignOutButton(AuthenticatedUser authenticatedUser) {
        addClassName(CLASS_NAME);
        setText("Sign out");
        addClickListener(e -> authenticatedUser.logout());
    }
}
