package org.hk.doghub.ui.components.shared;

import com.vaadin.flow.component.ClickEvent;
import com.vaadin.flow.component.button.Button;
import lombok.extern.slf4j.Slf4j;

import static com.vaadin.flow.component.Key.KEY_S;
import static com.vaadin.flow.component.KeyModifier.ALT;
import static com.vaadin.flow.component.button.ButtonVariant.LUMO_PRIMARY;
import static com.vaadin.flow.component.icon.VaadinIcon.SIGN_IN;

@Slf4j
public class SignupButton extends Button {

    public static final String CLASS_NAME = "signup-button";

    public SignupButton() {
        addClassName(CLASS_NAME);
        addThemeVariants(LUMO_PRIMARY);
        setIcon(SIGN_IN.create());
        setText("Sign up");
        addClickListener(this::signupClicked);
    }

    private void signupClicked(ClickEvent<Button> event) {
        log.info("Signup clicked");
    }
}
