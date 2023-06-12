package org.hk.doghub.ui.components.shared;

import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import org.hk.doghub.model.NamedEntity;
import org.hk.doghub.ui.views.app.EntityDataProvider;

import java.util.Optional;

import static com.vaadin.flow.component.orderedlayout.FlexComponent.Alignment.CENTER;

public class EntityInfoContainer<T extends NamedEntity, P extends EntityUpdateParameters> extends VerticalLayout {

    public static final String CLASS_NAME = "entity-info-container";

    protected final EntityDataProvider<T> entityDataProvider;

    private final EntityInfoContainerForm<T, P> form;

    private final InfoContainerButtons buttons;

    public EntityInfoContainer(EntityDataProvider<T> entityDataProvider, EntityInfoContainerForm<T, P> form) {
        this.entityDataProvider = entityDataProvider;
        this.form = form;
        addClassName(CLASS_NAME);
        setAlignItems(CENTER);
        buttons = new InfoContainerButtons();
        add(form, buttons);
    }

    public void setEntity(long entityId) {
        Optional<T> entityOptional = entityDataProvider.findById(entityId);
        entityOptional.ifPresent(form::setValue);
    }

    public void save() {
        form.save();
    }

    public void cancel() {
        form.cancel();
    }

    public void addInfoSaveListener(InfoSaveListener listener) {
        buttons.addInfoSaveListener(listener);
    }

    public void removeInfoSaveListener(InfoSaveListener listener) {
        buttons.removeInfoSaveListener(listener);
    }

    public void addInfoCancelListener(InfoCancelListener listener) {
        buttons.addInfoCancelListener(listener);
    }

    public void removeInfoCancelListener(InfoCancelListener listener) {
        buttons.removeInfoCancelListener(listener);
    }
}
