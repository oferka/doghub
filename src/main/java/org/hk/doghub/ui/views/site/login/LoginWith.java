package org.hk.doghub.ui.views.site.login;

import com.vaadin.flow.component.orderedlayout.VerticalLayout;

import static com.vaadin.flow.component.orderedlayout.FlexComponent.Alignment.CENTER;

public class LoginWith extends VerticalLayout {

    public static final String CLASS_NAME = LoginBody.CLASS_NAME + "-login-with";

    public LoginWith() {
        addClassName(CLASS_NAME);
        setAlignItems(CENTER);
        setSpacing(false);
        setPadding(false);
        LoginWithGoogle google = new LoginWithGoogle();
        LoginWithFacebook facebook = new LoginWithFacebook();
        add(google, facebook);
    }
}
