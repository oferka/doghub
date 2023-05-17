package org.hk.doghub.ui.views.site.login;

import com.vaadin.flow.router.RouterLink;
import org.hk.doghub.ui.views.site.signup.SignupView;

public class LoginFooterCreateAccountSignupLink extends RouterLink {

    public static final String CLASS_NAME = LoginFooterCreateAccount.CLASS_NAME + "-signup-link";

    public LoginFooterCreateAccountSignupLink() {
        super("Create Account", SignupView.class);
        addClassName(CLASS_NAME);
    }
}
