package org.hk.doghub.ui.components.shared;

import com.vaadin.flow.component.notification.Notification;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import lombok.extern.slf4j.Slf4j;
import org.hk.doghub.model.NamedEntity;
import org.hk.doghub.security.AuthenticatedUser;

import java.util.List;

@Slf4j
public abstract class EntityCreationContainerForm<T extends NamedEntity, P extends EntityCreationParameters> extends VerticalLayout {

    public static final String CLASS_NAME = "entity-creation-container-form";

    protected final AuthenticatedUser authenticatedUser;

    protected final EntityCreationService<T, P> creationService;

    public EntityCreationContainerForm(AuthenticatedUser authenticatedUser, EntityCreationService<T, P> creationService) {
        this.authenticatedUser = authenticatedUser;
        this.creationService = creationService;
        addClassName(CLASS_NAME);
        addClassName();
        setAlignItems(Alignment.CENTER);
        createFields();
        addFields();
    }

    protected abstract void addClassName();

    protected abstract void createFields();

    protected abstract void addFields();

    public void create() {
        EntityCreationParameters creationParameters = getCreationParameters();
        log.info("Create for entity with name '{}' has started", creationParameters.getName());
        List<String> violations = validateInput();
        if(violations.isEmpty()) {
            try {
                T entity = create(creationParameters);
                log.info("Create successfully for entity with name '{}'", entity.getName());
                showCreatedSuccessfullyNotification();
                postSuccessfulCreation(entity);

            }
            catch (Exception e) {
                log.error("Unexpected exception was thrown", e);
                showCreateFailedWithUnexpectedErrorNotification();
            }
        }
        else {
            showCreateFailedWithInvalidInputNotification(violations);
        }
        log.info("Create for entity with name '{}' has completed", creationParameters.getName());
    }

    protected abstract T create(EntityCreationParameters creationParameters);

    protected abstract EntityCreationParameters getCreationParameters();

    protected abstract List<String> validateInput();

    protected abstract void postSuccessfulCreation(T entity);

    private void showCreatedSuccessfullyNotification() {
        Notification notification = new SavedSuccessfullyNotification(); //todo
        notification.open();
    }

    private void showCreateFailedWithUnexpectedErrorNotification() {
        Notification notification = new SaveFailedWithUnexpectedErrorNotification(); //todo
        notification.open();
    }

    private void showCreateFailedWithInvalidInputNotification(List<String> violations) {
        Notification notification = new SaveFailedWithInvalidInputNotification(violations); //todo
        notification.open();
    }
}
