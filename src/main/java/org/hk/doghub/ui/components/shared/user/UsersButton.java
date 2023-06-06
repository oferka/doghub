package org.hk.doghub.ui.components.shared.user;

import com.vaadin.flow.component.ClickEvent;
import com.vaadin.flow.component.button.Button;
import lombok.extern.slf4j.Slf4j;

import static com.vaadin.flow.component.icon.VaadinIcon.TABLE;

@Slf4j
public class UsersButton extends Button {

    public static final String CLASS_NAME = "users-button";

    public UsersButton() {
        addClassName(CLASS_NAME);
        setIcon(TABLE.create());
        setText("Users");
        addClickListener(this::usersClicked);
    }

    private void usersClicked(ClickEvent<Button> event) {
        log.info("Users clicked");
    }
}
