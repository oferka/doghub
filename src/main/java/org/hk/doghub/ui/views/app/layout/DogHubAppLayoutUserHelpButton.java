package org.hk.doghub.ui.views.app.layout;

import com.vaadin.flow.component.ClickEvent;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.icon.Icon;
import com.vaadin.flow.component.notification.Notification;

import static com.vaadin.flow.component.button.ButtonVariant.LUMO_ICON;
import static com.vaadin.flow.component.icon.VaadinIcon.QUESTION_CIRCLE_O;
import static com.vaadin.flow.component.notification.Notification.Position.MIDDLE;

public class DogHubAppLayoutUserHelpButton extends Button {

    public static final String CLASS_NAME = DogHubAppLayoutHeader.CLASS_NAME + "-user-help-button";

    public DogHubAppLayoutUserHelpButton() {
        addClassName(CLASS_NAME);
        addThemeVariants(LUMO_ICON);
        getElement().setAttribute("aria-label", "Help");
        setTooltipText("Help");
        Icon helpIcon = QUESTION_CIRCLE_O.create();
        setIcon(helpIcon);
        addClickListener(this::helpClicked);
    }

    private void helpClicked(ClickEvent<Button> event) {
        Notification.show("Help clicked", 3000, MIDDLE);
    }
}
