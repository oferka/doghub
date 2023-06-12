package org.hk.doghub.ui.views.site.signup;

import com.vaadin.flow.component.orderedlayout.VerticalLayout;

import static com.vaadin.flow.component.orderedlayout.FlexComponent.Alignment.CENTER;

public class SignupFooter extends VerticalLayout {

    public static final String CLASS_NAME = "signup-footer";

    public SignupFooter() {
        addClassName(CLASS_NAME);
        setAlignItems(CENTER);
        SignupFooterAlreadyHaveAccount alreadyHaveAccount = new SignupFooterAlreadyHaveAccount();
        add(alreadyHaveAccount);
    }
}
