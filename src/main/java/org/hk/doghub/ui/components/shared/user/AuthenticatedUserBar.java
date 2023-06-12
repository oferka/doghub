package org.hk.doghub.ui.components.shared.user;

import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import org.hk.doghub.security.AuthenticatedUser;

public class AuthenticatedUserBar extends HorizontalLayout {

    public static final String CLASS_NAME = "authenticated-user-bar";

    public AuthenticatedUserBar(AuthenticatedUser authenticatedUser) {
        addClassName(CLASS_NAME);
        UserMenuBar userMenuBar = new UserMenuBar(authenticatedUser);
        add(userMenuBar);
    }
}
