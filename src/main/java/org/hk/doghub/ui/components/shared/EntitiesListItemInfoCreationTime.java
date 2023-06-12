package org.hk.doghub.ui.components.shared;

import com.vaadin.flow.component.html.Div;
import org.hk.doghub.model.AbstractEntity;

public class EntitiesListItemInfoCreationTime<T extends AbstractEntity> extends Div {

    public static final String CLASS_NAME = "entities-list-item-info-creation-time";

    public EntitiesListItemInfoCreationTime(T entity) {
        addClassNames(CLASS_NAME);
        CreationTimeLabel creationTime = new CreationTimeLabel(entity.getCreationTime());
        add(creationTime);
    }
}
