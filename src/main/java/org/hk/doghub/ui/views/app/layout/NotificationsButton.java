package org.hk.doghub.ui.views.app.layout;

import com.vaadin.flow.component.ClickEvent;
import com.vaadin.flow.component.button.Button;
import jakarta.validation.constraints.NotNull;
import lombok.extern.slf4j.Slf4j;

import static com.vaadin.flow.component.button.ButtonVariant.LUMO_ICON;
import static org.vaadin.lineawesome.LineAwesomeIcon.BELL_SOLID;

@Slf4j
public class NotificationsButton extends Button {

    public static final String CLASS_NAME = "notifications-button";

    public NotificationsButton(@NotNull String text) {
        addClassName(CLASS_NAME);
        addThemeVariants(LUMO_ICON);
        getElement().setAttribute("aria-label", "Notifications");
        setText(text);
        setTooltipText("Notifications");
        setIcon(BELL_SOLID.create());
        addClickListener(this::notificationsClicked);
    }

    private void notificationsClicked(ClickEvent<Button> event) {
        log.info("Notifications clicked");
    }
}
