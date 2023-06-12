package org.hk.doghub.ui.components.shared;

import com.vaadin.flow.component.ClickEvent;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.notification.Notification;

import static com.vaadin.flow.component.Key.KEY_S;
import static com.vaadin.flow.component.KeyModifier.ALT;
import static com.vaadin.flow.component.icon.VaadinIcon.SHARE;
import static com.vaadin.flow.component.notification.Notification.Position.MIDDLE;

public class EntityCreationViewHeaderActionsShareButton extends Button {

    public static final String CLASS_NAME = "entity-creation-view-header-actions-share-button";

    public EntityCreationViewHeaderActionsShareButton() {
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
