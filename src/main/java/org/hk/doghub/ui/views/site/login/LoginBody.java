package org.hk.doghub.ui.views.site.login;

import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.BeforeEnterEvent;

import static com.vaadin.flow.component.orderedlayout.FlexComponent.Alignment.CENTER;

public class LoginBody extends VerticalLayout {

    public static final String CLASS_NAME = "login-body";

    private final LoginWithEmail loginWithEmail;

    public LoginBody() {
        addClassName(CLASS_NAME);
        setAlignItems(CENTER);
        LoginWith loginWith = new LoginWith();
        LoginDivider loginDivider = new LoginDivider();
        loginWithEmail = new LoginWithEmail();
        RememberMe rememberMe = new RememberMe();
        add(loginWith, loginDivider, loginWithEmail, rememberMe);
    }

    public void setError(BeforeEnterEvent event) {
        loginWithEmail.setError(event);
    }

    public void setAction(String action) {
        loginWithEmail.setAction(action);
    }
}
