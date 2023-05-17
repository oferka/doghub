package org.hk.doghub.ui.views.site.signup;

import com.vaadin.flow.router.RouterLink;
import org.hk.doghub.ui.views.site.login.LoginView;

public class SignupFooterAlreadyHaveAccountLoginLink extends RouterLink {

    public static final String CLASS_NAME = SignupFooterAlreadyHaveAccount.CLASS_NAME + "-login-link";

    public SignupFooterAlreadyHaveAccountLoginLink() {
        super("Sign in", LoginView.class);
        addClassName(CLASS_NAME);
    }
}
