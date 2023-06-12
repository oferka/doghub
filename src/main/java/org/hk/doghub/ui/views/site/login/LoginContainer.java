package org.hk.doghub.ui.views.site.login;

import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.BeforeEnterEvent;

public class LoginContainer extends VerticalLayout {

    public static final String CLASS_NAME = "login-container";

    private final LoginBody body;

    public LoginContainer() {
        addClassName(CLASS_NAME);
        LoginHeader header = new LoginHeader();
        body = new LoginBody();
        LoginFooter footer = new LoginFooter();
        add(header, body, footer);
    }

    public void setError(BeforeEnterEvent event) {
        body.setError(event);
    }

    public void setAction(String action) {
        body.setAction(action);
    }
}
