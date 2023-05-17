package org.hk.doghub.ui.views.site.login;

import com.vaadin.flow.component.orderedlayout.VerticalLayout;

import static com.vaadin.flow.component.orderedlayout.FlexComponent.Alignment.CENTER;

public class LoginFooter extends VerticalLayout {

    public static final String CLASS_NAME = "login-footer";

    private final LoginFooterCreateAccount createAccount;

    public LoginFooter() {
        addClassName(CLASS_NAME);

        setAlignItems(CENTER);

        createAccount = new LoginFooterCreateAccount();
        add(createAccount);
    }
}
