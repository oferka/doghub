package org.hk.doghub.ui.views.app.users.create;

import com.vaadin.flow.component.ClickEvent;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.notification.Notification;
import org.hk.doghub.security.AuthenticatedUser;
import org.hk.doghub.ui.components.shared.UserCreationService;

import static com.vaadin.flow.component.Key.KEY_S;
import static com.vaadin.flow.component.KeyModifier.ALT;
import static com.vaadin.flow.component.icon.VaadinIcon.SHARE;
import static com.vaadin.flow.component.notification.Notification.Position.MIDDLE;

public class UserCreationViewHeaderActionsShareButton extends Button {

    public static final String CLASS_NAME = UserCreationViewHeaderActions.CLASS_NAME + "-share-button";

    public UserCreationViewHeaderActionsShareButton(AuthenticatedUser authenticatedUser, UserCreationService userCreationService) {
        addClassName(CLASS_NAME);

        setIcon(SHARE.create());
        setText("Share");
        addClickListener(this::shareClicked);
        addClickShortcut(KEY_S, ALT);
    }

    private void shareClicked(ClickEvent<Button> event) {
        Notification.show("Share clicked", 3000, MIDDLE);
    }
}
