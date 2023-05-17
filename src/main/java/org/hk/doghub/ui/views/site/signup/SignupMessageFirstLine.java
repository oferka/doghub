package org.hk.doghub.ui.views.site.signup;

import com.vaadin.flow.component.html.Span;

public class SignupMessageFirstLine extends Span {

    public static final String CLASS_NAME = SignupMessage.CLASS_NAME + "-first-line";

    public SignupMessageFirstLine() {
        addClassName(CLASS_NAME);
        setText("By creating an account, you are agreeing to our");
    }
}
