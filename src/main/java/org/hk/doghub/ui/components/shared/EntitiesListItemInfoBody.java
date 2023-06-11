package org.hk.doghub.ui.components.shared;

import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import org.hk.doghub.model.NamedEntity;
import org.hk.doghub.security.AuthenticatedUser;

public class EntitiesListItemInfoBody<T extends NamedEntity> extends VerticalLayout {

    public static final String CLASS_NAME = "entities-list-item-info-body";

    private final EntitiesListItemInfoCreationTime<T> creationTime;

    public EntitiesListItemInfoBody(T entity, AuthenticatedUser authenticatedUser) {
        addClassName(CLASS_NAME);
        creationTime = new EntitiesListItemInfoCreationTime<>(entity);
        add(creationTime);
    }
}
