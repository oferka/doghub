package org.hk.doghub.ui.components.shared;

import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import org.hk.doghub.model.NamedEntity;

import static com.vaadin.flow.component.orderedlayout.FlexComponent.Alignment.CENTER;

public class EntityViewBody<T extends NamedEntity, P extends EntityUpdateParameters> extends VerticalLayout {

    public static final String CLASS_NAME = EntityView.CLASS_NAME + "-body";
    private final EntityInfoContainer<T, P> entityInfo;

    public EntityViewBody(EntityInfoContainer<T, P> entityInfo) {
        this.entityInfo = entityInfo;
        addClassName(CLASS_NAME);
        setWidthFull();
        setAlignItems(CENTER);
        add(entityInfo);
    }

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
