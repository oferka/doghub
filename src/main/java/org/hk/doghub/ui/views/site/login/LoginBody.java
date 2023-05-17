package org.hk.doghub.ui.views.site.login;

import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.BeforeEnterEvent;

import static com.vaadin.flow.component.orderedlayout.FlexComponent.Alignment.CENTER;

public class LoginBody extends VerticalLayout {

    public static final String CLASS_NAME = "login-body";

    private final LoginWith loginWith;

    private final LoginDivider loginDivider;

    private final LoginWithEmail loginWithEmail;

    private final RememberMe rememberMe;

    public LoginBody() {
        addClassName(CLASS_NAME);

        setAlignItems(CENTER);

        loginWith = new LoginWith();
        add(loginWith);

        loginDivider = new LoginDivider();
        add(loginDivider);

        loginWithEmail = new LoginWithEmail();
        add(loginWithEmail);

        rememberMe = new RememberMe();
        add(rememberMe);
    }

    public void setError(BeforeEnterEvent event) {
        loginWithEmail.setError(event);
    }

    public void setAction(String action) {
        loginWithEmail.setAction(action);
    }
}
