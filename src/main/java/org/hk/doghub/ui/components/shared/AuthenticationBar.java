package org.hk.doghub.ui.components.shared;

import com.vaadin.flow.component.orderedlayout.HorizontalLayout;

public class AuthenticationBar extends HorizontalLayout {

    public static final String CLASS_NAME = "authentication-bar";

    private final LoginRouterLink login;
    private final SignupRouterLink signup;

    public AuthenticationBar() {
        addClassName(CLASS_NAME);

        login = new LoginRouterLink();
        add(login);

        signup = new SignupRouterLink();
        add(signup);
    }
}
