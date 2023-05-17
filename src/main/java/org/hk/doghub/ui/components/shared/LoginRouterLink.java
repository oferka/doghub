package org.hk.doghub.ui.components.shared;

import com.vaadin.flow.router.RouterLink;
import org.hk.doghub.ui.views.site.login.LoginView;

import static org.apache.commons.lang3.StringUtils.EMPTY;

public class LoginRouterLink extends RouterLink {

    public static final String CLASS_NAME = "login-router-link";

    private final LoginButton loginButton;

    public LoginRouterLink() {
        super(EMPTY, LoginView.class);
        addClassName(CLASS_NAME);

        loginButton = new LoginButton();
        add(loginButton);
    }
}
