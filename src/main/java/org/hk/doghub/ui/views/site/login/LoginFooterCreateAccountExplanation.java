package org.hk.doghub.ui.views.site.login;

import com.vaadin.flow.component.html.Span;

public class LoginFooterCreateAccountExplanation extends Span {

    public static final String CLASS_NAME = LoginFooterCreateAccount.CLASS_NAME + "-explanation";

    public LoginFooterCreateAccountExplanation() {
        addClassName(CLASS_NAME);
        setText("Don't have an account?");
    }
}
