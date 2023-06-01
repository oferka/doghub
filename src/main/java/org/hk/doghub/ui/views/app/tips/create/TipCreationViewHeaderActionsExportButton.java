package org.hk.doghub.ui.views.app.tips.create;

import com.vaadin.flow.component.ClickEvent;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.icon.VaadinIcon;
import com.vaadin.flow.component.notification.Notification;
import org.hk.doghub.security.AuthenticatedUser;

import static com.vaadin.flow.component.Key.KEY_E;
import static com.vaadin.flow.component.KeyModifier.ALT;
import static com.vaadin.flow.component.button.ButtonVariant.LUMO_PRIMARY;
import static com.vaadin.flow.component.notification.Notification.Position.MIDDLE;

public class TipCreationViewHeaderActionsExportButton extends Button {

    public static final String CLASS_NAME = TipCreationViewHeaderActions.CLASS_NAME + "-export-button";

    public TipCreationViewHeaderActionsExportButton(AuthenticatedUser authenticatedUser, TipCreationService tipCreationService) {
        addClassName(CLASS_NAME);

        setIcon(VaadinIcon.DOWNLOAD.create());
        setText("Export");
        addThemeVariants(LUMO_PRIMARY);
        addClickListener(this::exportClicked);
        addClickShortcut(KEY_E, ALT);
    }

    private void exportClicked(ClickEvent<Button> event) {
        Notification.show("Export clicked", 3000, MIDDLE);
    }
}
