package org.hk.doghub.ui.views.app;

import com.vaadin.flow.component.ClickEvent;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.icon.Icon;
import com.vaadin.flow.component.notification.Notification;

import static com.vaadin.flow.component.button.ButtonVariant.LUMO_ICON;
import static com.vaadin.flow.component.icon.VaadinIcon.USER_CARD;
import static com.vaadin.flow.component.notification.Notification.Position.MIDDLE;

public class DogHubAppLayoutUserProfileButton extends Button {

    public static final String CLASS_NAME = DogHubAppLayoutHeader.CLASS_NAME + "-user-profile-button";

    public DogHubAppLayoutUserProfileButton() {
        addClassName(CLASS_NAME);
        addThemeVariants(LUMO_ICON);
        getElement().setAttribute("aria-label", "Profile");
        setTooltipText("Profile");
        Icon profileIcon = USER_CARD.create();
        setIcon(profileIcon);
        addClickListener(this::profileClicked);
    }

    private void profileClicked(ClickEvent<Button> event) {
        Notification.show("Profile clicked", 3000, MIDDLE);
    }
}
