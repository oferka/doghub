package org.hk.doghub.ui.components.shared;

import com.vaadin.flow.component.orderedlayout.HorizontalLayout;

public class AuthenticationBar extends HorizontalLayout {

    public static final String CLASS_NAME = "authentication-bar";

    private final LoginRouterLink loginRouterLink;
    private final SignupRouterLink signupRouterLink;

    public AuthenticationBar() {
        addClassName(CLASS_NAME);

        loginRouterLink = new LoginRouterLink();
        add(loginRouterLink);

        signupRouterLink = new SignupRouterLink();
        add(signupRouterLink);
    }
}
