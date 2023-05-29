package org.hk.doghub.ui.views.app.users.user;

import com.vaadin.flow.component.ClickEvent;
import com.vaadin.flow.component.button.Button;
import lombok.extern.slf4j.Slf4j;

import static com.vaadin.flow.component.Key.KEY_P;
import static com.vaadin.flow.component.KeyModifier.ALT;
import static com.vaadin.flow.component.icon.VaadinIcon.ARROW_LEFT;

@Slf4j
public class PreviousUserButton extends Button {

    public static final String CLASS_NAME = "previous-user-button";

    public PreviousUserButton() {
        addClassName(CLASS_NAME);
        setIcon(ARROW_LEFT.create());
        setText("Previous User");
        addClickListener(this::previousUserClicked);
        addClickShortcut(KEY_P, ALT);
    }

    private void previousUserClicked(ClickEvent<Button> event) {
        log.info("Previous user clicked");
    }
}
