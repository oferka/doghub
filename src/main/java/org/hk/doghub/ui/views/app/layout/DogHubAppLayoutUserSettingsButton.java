package org.hk.doghub.ui.views.app.layout;

import com.vaadin.flow.component.ClickEvent;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.icon.Icon;
import com.vaadin.flow.component.notification.Notification;

import static com.vaadin.flow.component.button.ButtonVariant.LUMO_ICON;
import static com.vaadin.flow.component.icon.VaadinIcon.COG_O;
import static com.vaadin.flow.component.notification.Notification.Position.MIDDLE;

public class DogHubAppLayoutUserSettingsButton extends Button {

    public static final String CLASS_NAME = DogHubAppLayoutHeader.CLASS_NAME + "-user-settings-button";

    public DogHubAppLayoutUserSettingsButton() {
        addClassName(CLASS_NAME);
        addThemeVariants(LUMO_ICON);
        getElement().setAttribute("aria-label", "Settings");
        setTooltipText("Settings");
        Icon settingsIcon = COG_O.create();
        setIcon(settingsIcon);
        addClickListener(this::settingsClicked);
    }

    private void settingsClicked(ClickEvent<Button> event) {
        Notification.show("Settings clicked", 3000, MIDDLE);
    }
}
