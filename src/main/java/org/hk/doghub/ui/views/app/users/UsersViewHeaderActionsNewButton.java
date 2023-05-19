package org.hk.doghub.ui.views.app.users;

import com.vaadin.flow.component.ClickEvent;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.notification.Notification;

import static com.vaadin.flow.component.Key.KEY_N;
import static com.vaadin.flow.component.KeyModifier.ALT;
import static com.vaadin.flow.component.button.ButtonVariant.LUMO_PRIMARY;
import static com.vaadin.flow.component.icon.VaadinIcon.PLUS_CIRCLE;
import static com.vaadin.flow.component.notification.Notification.Position.MIDDLE;

public class UsersViewHeaderActionsNewButton extends Button {

    public static final String CLASS_NAME = UsersViewHeaderActions.CLASS_NAME + "-new-button";

    public UsersViewHeaderActionsNewButton(UsersDataProvider usersViewDataProvider, UsersViewState usersViewState) {
        addClassName(CLASS_NAME);

        setIcon(PLUS_CIRCLE.create());
        setText("New User");
        addThemeVariants(LUMO_PRIMARY);
        addClickListener(this::newClicked);
        addClickShortcut(KEY_N, ALT);
    }

    private void newClicked(ClickEvent<Button> event) {
        Notification.show("New Clicked", 3000, MIDDLE);
    }
}
