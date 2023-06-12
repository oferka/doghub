package org.hk.doghub.ui.components.shared;

import com.vaadin.flow.component.Component;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import org.hk.doghub.model.NamedEntity;

import java.util.List;

public class EntitiesListItemInfoBody<T extends NamedEntity> extends VerticalLayout {

    public static final String CLASS_NAME = "entities-list-item-info-body";

    public EntitiesListItemInfoBody(T entity, List<Component> components) {
        addClassName(CLASS_NAME);
        EntitiesListItemInfoCreationTime<T> creationTime = new EntitiesListItemInfoCreationTime<>(entity);
        add(creationTime);
        add(components);
    }
}
