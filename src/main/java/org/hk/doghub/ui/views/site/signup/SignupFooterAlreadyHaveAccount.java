package org.hk.doghub.ui.views.site.signup;

import com.vaadin.flow.component.orderedlayout.VerticalLayout;

import static com.vaadin.flow.component.orderedlayout.FlexComponent.Alignment.CENTER;

public class SignupFooterAlreadyHaveAccount extends VerticalLayout {

    public static final String CLASS_NAME = SignupFooter.CLASS_NAME + "-already-have-account";

    public SignupFooterAlreadyHaveAccount() {
        addClassName(CLASS_NAME);
        setAlignItems(CENTER);
        setSpacing(false);
        SignupFooterAlreadyHaveAccountExplanation explanation = new SignupFooterAlreadyHaveAccountExplanation();
        SignupFooterAlreadyHaveAccountLoginLink loginLink = new SignupFooterAlreadyHaveAccountLoginLink();
        add(explanation, loginLink);
    }
}
