package org.hk.doghub.ui.components.shared;

import com.vaadin.flow.component.formlayout.FormLayout;
import com.vaadin.flow.component.notification.Notification;
import lombok.extern.slf4j.Slf4j;
import org.hk.doghub.model.NamedEntity;
import org.hk.doghub.ui.views.app.EntityDataProvider;

import java.util.List;
import java.util.Optional;

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

    public abstract void setValue(T value);

    public void save() {
        EntityUpdateParameters updateParameters = getUpdateParameters();
        log.info("Save for entity with ID '{}' has started", updateParameters.getId());
        List<String> violations = validateInput();
        if(violations.isEmpty()) {
            try {
                T entity = update(updateParameters);
                log.info("Save successfully for entity with ID '{}'", entity.getId());
                showSavedSuccessfullyNotification();
            }
            catch (Exception e) {
                log.error("Unexpected exception was thrown", e);
                showSaveFailedWithUnexpectedErrorNotification();
            }
        }
        else {
            showSaveFailedWithInvalidInputNotification(violations);
        }
        log.info("Save for entity with ID '{}' has completed", updateParameters.getId());
    }

    protected abstract T update(EntityUpdateParameters updateParameters);

    protected abstract EntityUpdateParameters getUpdateParameters();

    protected abstract List<String> validateInput();

    public void cancel() {
        EntityUpdateParameters updateParameters = getUpdateParameters();
        Optional<T> entityOptional = entityDataProvider.findById(updateParameters.getId());
        entityOptional.ifPresent(this::setValue);
    }

    private void showSavedSuccessfullyNotification() {
        Notification notification = new SavedSuccessfullyNotification();
        notification.open();
    }

    private void showSaveFailedWithUnexpectedErrorNotification() {
        Notification notification = new SaveFailedWithUnexpectedErrorNotification();
        notification.open();
    }

    private void showSaveFailedWithInvalidInputNotification(List<String> violations) {
        Notification notification = new SaveFailedWithInvalidInputNotification(violations);
        notification.open();
    }
}
