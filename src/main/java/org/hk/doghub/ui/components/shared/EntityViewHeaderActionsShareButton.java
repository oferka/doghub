package org.hk.doghub.ui.components.shared;

import com.vaadin.flow.component.ClickEvent;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.notification.Notification;
import org.hk.doghub.model.NamedEntity;
import org.hk.doghub.ui.views.app.EntityDataProvider;

import java.util.Optional;

import static com.vaadin.flow.component.icon.VaadinIcon.SHARE;
import static com.vaadin.flow.component.notification.Notification.Position.MIDDLE;

public class EntityViewHeaderActionsShareButton<T extends NamedEntity> extends Button {

    public static final String CLASS_NAME = EntityViewHeaderActions.CLASS_NAME + "-share-button";

    private final EntityDataProvider<T> entityDataProvider;
    private long selectedEntityId;

    public EntityViewHeaderActionsShareButton(EntityDataProvider<T> entityDataProvider) {
        this.entityDataProvider = entityDataProvider;
        addClassName(CLASS_NAME);
        setIcon(SHARE.create());
        setText("Share");
        addClickListener(this::shareClicked);
    }

    private void shareClicked(ClickEvent<Button> event) {
        String name = null;
        Optional<T> entity = entityDataProvider.findById(selectedEntityId);
        if(entity.isPresent()) {
            name = entity.get().getName();
        }
        Notification.show("Share clicked. Selected entity name is: " + name, 3000, MIDDLE);
    }

    public void selectedEntityChanged(long selectedEntityId) {
        this.selectedEntityId = selectedEntityId;
    }
}
