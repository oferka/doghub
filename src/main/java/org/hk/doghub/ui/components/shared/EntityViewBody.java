package org.hk.doghub.ui.components.shared;

import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import org.hk.doghub.model.NamedEntity;
import org.hk.doghub.ui.views.app.EntityDataProvider;

import static com.vaadin.flow.component.orderedlayout.FlexComponent.Alignment.CENTER;

public abstract class EntityViewBody<T extends NamedEntity, P extends EntityUpdateParameters> extends VerticalLayout {

    public static final String CLASS_NAME = "entity-view-body";

    protected final EntityDataProvider<T> entityDataProvider;

    protected final EntityUpdateService<T, P> entityUpdateService;

    private final EntityInfoContainer<T, P> entityInfo;

    public EntityViewBody(EntityDataProvider<T> entityDataProvider, EntityUpdateService<T, P> entityUpdateService) {
        this.entityDataProvider = entityDataProvider;
        this.entityUpdateService = entityUpdateService;
        addClassName(CLASS_NAME);
        setWidthFull();
        setAlignItems(CENTER);
        entityInfo = getEntityInfo();
        add(entityInfo);
    }

    protected abstract EntityInfoContainer<T, P> getEntityInfo();

    public void selectedEntityChanged(long selectedEntityId) {
        entityInfo.setEntity(selectedEntityId);
    }

    public void addInfoSaveListener(InfoSaveListener listener) {
        entityInfo.addInfoSaveListener(listener);
    }

    public void addInfoCancelListener(InfoCancelListener listener) {
        entityInfo.addInfoCancelListener(listener);
    }

    public void removeInfoSaveListener(InfoSaveListener listener) {
        entityInfo.removeInfoSaveListener(listener);
    }

    public void removeInfoCancelListener(InfoCancelListener listener) {
        entityInfo.removeInfoCancelListener(listener);
    }

    public void save() {
        entityInfo.save();
    }

    public void cancel() {
        entityInfo.cancel();
    }
}
