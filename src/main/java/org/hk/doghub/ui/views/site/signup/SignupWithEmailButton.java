package org.hk.doghub.ui.views.site.signup;

import com.vaadin.flow.component.button.Button;

import static com.vaadin.flow.component.Key.KEY_C;
import static com.vaadin.flow.component.KeyModifier.ALT;

public class SignupWithEmailButton extends Button {

    public static final String CLASS_NAME = SignupWithEmail.CLASS_NAME + "-button";

    public SignupWithEmailButton() {
        addClassName(CLASS_NAME);
        setText("Continue");
        addClickShortcut(KEY_C, ALT);
    }
}
