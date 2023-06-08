package org.hk.doghub.ui.components.shared;

import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import org.hk.doghub.model.NamedEntity;
import org.hk.doghub.ui.views.app.EntityDataProvider;

import java.util.Optional;

import static com.vaadin.flow.component.orderedlayout.FlexComponent.Alignment.CENTER;

public abstract class EntityInfoContainer<T extends NamedEntity, P extends EntityUpdateParameters> extends VerticalLayout {

    public static final String CLASS_NAME = "entity-info-container";

    protected final EntityDataProvider<T> entityDataProvider;

    protected final EntityUpdateService<T, P> entityUpdateService;

    private final EntityInfoContainerForm<T, P> form;

    private final InfoContainerButtons buttons;

    public EntityInfoContainer(EntityDataProvider<T> entityDataProvider, EntityUpdateService<T, P> entityUpdateService) {
        this.entityDataProvider = entityDataProvider;
        this.entityUpdateService = entityUpdateService;
        addClassName(CLASS_NAME);

        setAlignItems(CENTER);

        form = getForm();
        add(form);

        buttons = new InfoContainerButtons();
        add(buttons);
    }

    protected abstract EntityInfoContainerForm<T, P> getForm();

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
