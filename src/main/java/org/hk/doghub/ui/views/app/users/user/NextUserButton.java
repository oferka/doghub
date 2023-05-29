package org.hk.doghub.ui.views.app.users.user;

import com.vaadin.flow.component.ClickEvent;
import com.vaadin.flow.component.button.Button;
import lombok.extern.slf4j.Slf4j;

import static com.vaadin.flow.component.Key.KEY_N;
import static com.vaadin.flow.component.KeyModifier.ALT;
import static com.vaadin.flow.component.icon.VaadinIcon.ARROW_RIGHT;

@Slf4j
public class NextUserButton extends Button {

    public static final String CLASS_NAME = "next-user-button";

    public NextUserButton() {
        addClassName(CLASS_NAME);
        setIcon(ARROW_RIGHT.create());
        setText("Next User");
        addClickListener(this::nextUserClicked);
        addClickShortcut(KEY_N, ALT);
    }

    private void nextUserClicked(ClickEvent<Button> event) {
        log.info("Next user clicked");
    }
}
