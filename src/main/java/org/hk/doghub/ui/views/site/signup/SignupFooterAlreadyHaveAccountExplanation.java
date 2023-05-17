package org.hk.doghub.ui.views.site.signup;

import com.vaadin.flow.component.html.Span;

public class SignupFooterAlreadyHaveAccountExplanation extends Span {

    public static final String CLASS_NAME = SignupFooterAlreadyHaveAccount.CLASS_NAME + "-explanation";

    public SignupFooterAlreadyHaveAccountExplanation() {
        addClassName(CLASS_NAME);
        setText("Already have an account?");
    }
}
