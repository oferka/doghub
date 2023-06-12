package org.hk.doghub.ui.components.shared;

import com.vaadin.flow.component.orderedlayout.HorizontalLayout;

public class AuthenticationBar extends HorizontalLayout {

    public static final String CLASS_NAME = "authentication-bar";

    public AuthenticationBar() {
        addClassName(CLASS_NAME);
        LoginRouterLink login = new LoginRouterLink();
        SignupRouterLink signup = new SignupRouterLink();
        add(login, signup);
    }
}
