package org.hk.doghub.ui.views.site.login;

import com.vaadin.flow.component.orderedlayout.VerticalLayout;

import static com.vaadin.flow.component.orderedlayout.FlexComponent.Alignment.CENTER;

public class LoginFooterCreateAccount extends VerticalLayout {

    public static final String CLASS_NAME = LoginFooter.CLASS_NAME + "-create-account";

    public LoginFooterCreateAccount() {
        addClassName(CLASS_NAME);
        setAlignItems(CENTER);
        setSpacing(false);
        LoginFooterCreateAccountExplanation explanation = new LoginFooterCreateAccountExplanation();
        LoginFooterCreateAccountSignupLink signupLink = new LoginFooterCreateAccountSignupLink();
        add(explanation, signupLink);
    }
}
