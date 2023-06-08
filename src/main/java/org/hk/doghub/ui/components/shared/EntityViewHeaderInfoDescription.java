package org.hk.doghub.ui.components.shared;

import com.vaadin.flow.component.html.Span;
import org.hk.doghub.model.NamedEntity;
import org.hk.doghub.ui.views.app.EntityDataProvider;

import java.util.Optional;

public class EntityViewHeaderInfoDescription<T extends NamedEntity> extends Span {

    public static final String CLASS_NAME = EntityViewHeaderInfo.CLASS_NAME + "-description";

    private final EntityDataProvider<T> entityDataProvider;

    public EntityViewHeaderInfoDescription(EntityDataProvider<T> entityDataProvider) {
        this.entityDataProvider = entityDataProvider;
        addClassName(CLASS_NAME);
    }

    public void selectedEntityChanged(long selectedEntityId) {
        Optional<T> entity = entityDataProvider.findById(selectedEntityId);
        entity.ifPresent(value -> setText("Selected Entity Name: " + value.getName()));
    }
}
