package org.hk.doghub.ui.views.site.signup;

import com.vaadin.flow.component.orderedlayout.VerticalLayout;

import static com.vaadin.flow.component.orderedlayout.FlexComponent.Alignment.CENTER;

public class SignupFooterAlreadyHaveAccount extends VerticalLayout {

    public static final String CLASS_NAME = SignupFooter.CLASS_NAME + "-already-have-account";

    private final SignupFooterAlreadyHaveAccountExplanation explanation;

    private final SignupFooterAlreadyHaveAccountLoginLink loginLink;

    public SignupFooterAlreadyHaveAccount() {
        addClassName(CLASS_NAME);

        setAlignItems(CENTER);
        setSpacing(false);

        explanation = new SignupFooterAlreadyHaveAccountExplanation();
        add(explanation);

        loginLink = new SignupFooterAlreadyHaveAccountLoginLink();
        add(loginLink);
    }
}
