package org.hk.doghub.ui.components.shared;

import com.vaadin.flow.component.ClickEvent;
import com.vaadin.flow.component.button.Button;
import lombok.extern.slf4j.Slf4j;

import static com.vaadin.flow.component.Key.KEY_U;
import static com.vaadin.flow.component.KeyModifier.ALT;
import static com.vaadin.flow.component.icon.VaadinIcon.TABLE;

@Slf4j
public class UsersButton extends Button {

    public static final String CLASS_NAME = "users-button";

    public UsersButton() {
        addClassName(CLASS_NAME);
        setIcon(TABLE.create());
        setText("Users");
        addClickListener(this::UsersClicked);
        addClickShortcut(KEY_U, ALT);
    }

    private void UsersClicked(ClickEvent<Button> event) {
        log.info("Users clicked");
    }
}
