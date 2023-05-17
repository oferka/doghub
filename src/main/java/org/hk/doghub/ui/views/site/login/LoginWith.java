package org.hk.doghub.ui.views.site.login;

import com.vaadin.flow.component.orderedlayout.VerticalLayout;

import static com.vaadin.flow.component.orderedlayout.FlexComponent.Alignment.CENTER;

public class LoginWith extends VerticalLayout {

    public static final String CLASS_NAME = LoginBody.CLASS_NAME + "-login-with";

    private final LoginWithGoogle google;

    private final LoginWithFacebook facebook;

    public LoginWith() {
        addClassName(CLASS_NAME);

        setAlignItems(CENTER);
        setSpacing(false);
        setPadding(false);

        google = new LoginWithGoogle();
        add(google);

        facebook = new LoginWithFacebook();
        add(facebook);
    }
}
