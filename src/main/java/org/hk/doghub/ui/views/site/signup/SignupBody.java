package org.hk.doghub.ui.views.site.signup;

import com.vaadin.flow.component.orderedlayout.VerticalLayout;

import static com.vaadin.flow.component.orderedlayout.FlexComponent.Alignment.CENTER;

public class SignupBody extends VerticalLayout {

    public static final String CLASS_NAME = "signup-body";

    private final SignupWith signupWith;

    private final SignupDivider signupDivider;

    private final SignupWithEmail signupWithEmail;

    private final SignupMessage signupMessage;

    public SignupBody(SignupService signupService) {
        addClassName(CLASS_NAME);

        setAlignItems(CENTER);

        signupWith = new SignupWith();
        add(signupWith);

        signupDivider = new SignupDivider();
        add(signupDivider);

        signupWithEmail = new SignupWithEmail(signupService);
        add(signupWithEmail);

        signupMessage = new SignupMessage();
        add(signupMessage);
    }
}
