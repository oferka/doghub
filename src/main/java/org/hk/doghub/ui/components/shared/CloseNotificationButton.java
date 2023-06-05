package org.hk.doghub.ui.components.shared;

import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.notification.Notification;

import static com.vaadin.flow.component.button.ButtonVariant.LUMO_TERTIARY_INLINE;
import static com.vaadin.flow.component.icon.VaadinIcon.CLOSE_SMALL;

public class CloseNotificationButton extends Button {

    public static final String CLASS_NAME = "close-notification-button";

    public CloseNotificationButton(Notification notification) {
        addClassName(CLASS_NAME);
        setIcon(CLOSE_SMALL.create());
        addThemeVariants(LUMO_TERTIARY_INLINE);
        addClickListener(clickEvent -> notification.close());
    }
}
