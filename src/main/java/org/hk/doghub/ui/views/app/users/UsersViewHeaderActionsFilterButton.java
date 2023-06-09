package org.hk.doghub.ui.views.app.users;

import com.vaadin.flow.component.ClickEvent;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.notification.Notification;

import static com.vaadin.flow.component.Key.KEY_F;
import static com.vaadin.flow.component.KeyModifier.ALT;
import static com.vaadin.flow.component.icon.VaadinIcon.FILTER;
import static com.vaadin.flow.component.notification.Notification.Position.MIDDLE;

public class UsersViewHeaderActionsFilterButton extends Button {

    public static final String CLASS_NAME = UsersViewHeaderActions.CLASS_NAME + "-filter-button";

    public UsersViewHeaderActionsFilterButton() {
        addClassName(CLASS_NAME);

        setIcon(FILTER.create());
        setText("Filter");
        addClickListener(this::filterClicked);
        addClickShortcut(KEY_F, ALT);
    }

    private void filterClicked(ClickEvent<Button> event) {
        Notification.show("Filter Clicked", 3000, MIDDLE);
    }
}
