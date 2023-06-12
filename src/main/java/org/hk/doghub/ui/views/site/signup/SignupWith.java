package org.hk.doghub.ui.views.site.signup;

import com.vaadin.flow.component.orderedlayout.VerticalLayout;

import static com.vaadin.flow.component.orderedlayout.FlexComponent.Alignment.CENTER;

public class SignupWith extends VerticalLayout {

    public static final String CLASS_NAME = SignupBody.CLASS_NAME + "-signup-with";

    public SignupWith() {
        addClassName(CLASS_NAME);
        setAlignItems(CENTER);
        setSpacing(false);
        setPadding(false);
        SignupWithGoogle google = new SignupWithGoogle();
        SignupWithFacebook facebook = new SignupWithFacebook();
        add(google, facebook);
    }
}
