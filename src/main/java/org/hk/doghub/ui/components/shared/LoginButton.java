package org.hk.doghub.ui.components.shared;

import com.vaadin.flow.component.ClickEvent;
import com.vaadin.flow.component.button.Button;
import lombok.extern.slf4j.Slf4j;

import static com.vaadin.flow.component.Key.KEY_L;
import static com.vaadin.flow.component.KeyModifier.ALT;
import static org.vaadin.lineawesome.LineAwesomeIcon.USER_CHECK_SOLID;

@Slf4j
public class LoginButton extends Button {

    public static final String CLASS_NAME = "login-button";

    public LoginButton() {
        addClassName(CLASS_NAME);
        setIcon(USER_CHECK_SOLID.create());
        setText("Log in");
        addClickListener(this::loginClicked);
        addClickShortcut(KEY_L, ALT);
    }

    private void loginClicked(ClickEvent<Button> event) {
        log.info("Login clicked");
    }
}
