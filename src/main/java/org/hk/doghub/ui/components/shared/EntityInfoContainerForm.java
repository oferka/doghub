package org.hk.doghub.ui.components.shared;

import com.vaadin.flow.component.formlayout.FormLayout;
import lombok.extern.slf4j.Slf4j;
import org.hk.doghub.model.NamedEntity;
import org.hk.doghub.ui.views.app.EntityDataProvider;

@Slf4j
public abstract class EntityInfoContainerForm<T extends NamedEntity, P extends EntityUpdateParameters> extends FormLayout {

    public static final String CLASS_NAME = "entity-info-container-form";

    protected final EntityDataProvider<T> entityDataProvider;

    protected final EntityUpdateService<T, P> entityUpdateService;

    public EntityInfoContainerForm(EntityDataProvider<T> entityDataProvider, EntityUpdateService<T, P> entityUpdateService) {
        this.entityDataProvider = entityDataProvider;
        this.entityUpdateService = entityUpdateService;
        addClassName(CLASS_NAME);
    }
}
