package org.hk.doghub.ui.components.shared;

import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import org.hk.doghub.model.NamedEntity;
import org.hk.doghub.ui.components.shared.user.EntityCreationContainer;

import static com.vaadin.flow.component.orderedlayout.FlexComponent.Alignment.CENTER;

public class EntityCreationViewBody<T extends NamedEntity, P extends EntityCreationParameters> extends HorizontalLayout {

    public static final String CLASS_NAME = "entity-creation-view-body";

    public EntityCreationViewBody(EntityCreationContainerForm<T, P> form) {
        addClassName(CLASS_NAME);
        setWidthFull();
        setAlignItems(CENTER);
        EntityCreationContainer<T, P> creationContainer = new EntityCreationContainer<>(form);
        add(creationContainer);
    }
}
