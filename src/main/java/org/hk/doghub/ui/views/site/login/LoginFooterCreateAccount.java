package org.hk.doghub.ui.views.site.login;

import com.vaadin.flow.component.orderedlayout.VerticalLayout;

import static com.vaadin.flow.component.orderedlayout.FlexComponent.Alignment.CENTER;

public class LoginFooterCreateAccount extends VerticalLayout {

    public static final String CLASS_NAME = LoginFooter.CLASS_NAME + "-create-account";

    private final LoginFooterCreateAccountExplanation explanation;

    private final LoginFooterCreateAccountSignupLink signupLink;

    public LoginFooterCreateAccount() {
        addClassName(CLASS_NAME);

        setAlignItems(CENTER);
        setSpacing(false);

        explanation = new LoginFooterCreateAccountExplanation();
        add(explanation);

        signupLink = new LoginFooterCreateAccountSignupLink();
        add(signupLink);
    }
}
