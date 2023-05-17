package org.hk.doghub.ui.views.site.login;

import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.BeforeEnterEvent;

public class LoginContainer extends VerticalLayout {

    public static final String CLASS_NAME = "login-container";

    private final LoginHeader header;

    private final LoginBody body;

    private final LoginFooter footer;

    public LoginContainer() {
        addClassName(CLASS_NAME);

        header = new LoginHeader();
        add(header);

        body = new LoginBody();
        add(body);

        footer = new LoginFooter();
        add(footer);
    }

    public void setError(BeforeEnterEvent event) {
        body.setError(event);
    }

    public void setAction(String action) {
        body.setAction(action);
    }
}
