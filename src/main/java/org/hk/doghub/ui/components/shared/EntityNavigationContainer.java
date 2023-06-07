package org.hk.doghub.ui.components.shared;

import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import lombok.extern.slf4j.Slf4j;
import org.hk.doghub.security.AuthenticatedUser;
import org.hk.doghub.ui.views.app.users.UserDataProvider;

import static com.vaadin.flow.component.orderedlayout.FlexComponent.JustifyContentMode.CENTER;

@Slf4j
public class EntityNavigationContainer extends HorizontalLayout {

    public static final String CLASS_NAME = "entity-navigation-container";

    private final PreviousEntityRouterLink previous;

    private final EntitiesRouterLink entities;

    private final NextEntityRouterLink next;

    private long selectedEntityId;

    public EntityNavigationContainer(UserDataProvider userDataProvider, AuthenticatedUser authenticatedUser, String entityLabel, Class entityClass, String entitiesLabel, Class entitiesClass) {
        addClassName(CLASS_NAME);

        setWidthFull();
        setJustifyContentMode(CENTER);

        previous = new PreviousEntityRouterLink(userDataProvider, authenticatedUser, entityLabel, entityClass);
        add(previous);

        entities = new EntitiesRouterLink(entitiesClass, entitiesLabel);
        add(entities);

        next = new NextEntityRouterLink(userDataProvider, authenticatedUser, entityLabel, entityClass);
        add(next);
    }

    public long getSelectedEntityId() {
        return selectedEntityId;
    }

    public void setSelectedEntityId(long selectedEntityId) {
        this.selectedEntityId = selectedEntityId;
    }

    public void selectedEntityChanged(long selectedEntityId) {
        setSelectedEntityId(selectedEntityId);
        next.selectedEntityChanged(selectedEntityId);
        previous.selectedEntityChanged(selectedEntityId);
    }

    public void save() {
        selectedEntityChanged(selectedEntityId);
    }

    public void cancel() {
        log.info("Cancel");
    }
}
