package org.hk.doghub.ui.components.shared;

import com.vaadin.flow.component.html.H2;
import org.hk.doghub.model.NamedEntity;
import org.hk.doghub.ui.views.app.EntityDataProvider;

import java.util.Optional;

public class EntityViewHeaderInfoTitleText<T extends NamedEntity> extends H2 {

    public static final String CLASS_NAME = "entity-view-header-info-title-text";

    private final EntityDataProvider<T> entityDataProvider;

    public EntityViewHeaderInfoTitleText(EntityDataProvider<T> entityDataProvider) {
        this.entityDataProvider = entityDataProvider;
        addClassName(CLASS_NAME);
    }

    public void selectedEntityChanged(long selectedEntityId) {
        setText("Selected Entity: " + selectedEntityId);
        Optional<T> entity = entityDataProvider.findById(selectedEntityId);
        entity.ifPresent(value -> setText(value.getName()));
    }
}
