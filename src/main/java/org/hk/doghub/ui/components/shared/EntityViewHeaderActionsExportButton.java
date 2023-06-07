package org.hk.doghub.ui.components.shared;

import com.vaadin.flow.component.ClickEvent;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.icon.VaadinIcon;
import com.vaadin.flow.component.notification.Notification;
import org.hk.doghub.model.NamedEntity;
import org.hk.doghub.ui.views.app.EntityDataProvider;

import java.util.Optional;

import static com.vaadin.flow.component.button.ButtonVariant.LUMO_PRIMARY;
import static com.vaadin.flow.component.notification.Notification.Position.MIDDLE;

public class EntityViewHeaderActionsExportButton<T extends NamedEntity> extends Button {

    public static final String CLASS_NAME = "entity-view-header-actions-export-button";

    private final EntityDataProvider<T> entityDataProvider;
    private long selectedEntityId;

    public EntityViewHeaderActionsExportButton(EntityDataProvider<T> entityDataProvider) {
        this.entityDataProvider = entityDataProvider;
        addClassName(CLASS_NAME);
        setIcon(VaadinIcon.DOWNLOAD.create());
        setText("Export");
        addThemeVariants(LUMO_PRIMARY);
        addClickListener(this::exportClicked);
    }

    private void exportClicked(ClickEvent<Button> event) {
        String name = null;
        Optional<T> entity = entityDataProvider.findById(selectedEntityId);
        if(entity.isPresent()) {
            name = entity.get().getName();
        }
        Notification.show("Export clicked. Selected entity name is: " + name, 3000, MIDDLE);
    }

    public void selectedEntityChanged(long selectedEntityId) {
        this.selectedEntityId = selectedEntityId;
    }
}
