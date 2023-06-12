package org.hk.doghub.ui.components.shared;

import com.vaadin.flow.router.RouterLink;
import org.hk.doghub.ui.views.site.login.LoginView;

import static org.apache.commons.lang3.StringUtils.EMPTY;

public class LoginRouterLink extends RouterLink {

    public static final String CLASS_NAME = "login-router-link";

    public LoginRouterLink() {
        super(EMPTY, LoginView.class);
        addClassName(CLASS_NAME);
        LoginButton login = new LoginButton();
        add(login);
    }
}
