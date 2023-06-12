package org.hk.doghub.ui.components.shared;

import com.vaadin.flow.component.Component;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.router.HasUrlParameter;
import org.hk.doghub.model.AbstractEntity;
import org.hk.doghub.security.AuthenticatedUser;
import org.hk.doghub.ui.views.app.EntityDataProvider;

import static com.vaadin.flow.component.orderedlayout.FlexComponent.JustifyContentMode.CENTER;

public class EntityViewFooter<T extends AbstractEntity, C extends Component & HasUrlParameter<Long>> extends HorizontalLayout {

    public static final String CLASS_NAME = EntityView.CLASS_NAME + "-footer";

    private final EntityNavigationContainer<T, C> navigationContainer;

    public EntityViewFooter(EntityDataProvider<T> entityDataProvider, AuthenticatedUser authenticatedUser, String entityLabel, Class<? extends C> entityClass, String entitiesLabel, Class<? extends Component> entitiesClass) {
        addClassName(CLASS_NAME);
        setWidthFull();
        setJustifyContentMode(CENTER);
        navigationContainer = new EntityNavigationContainer<>(entityDataProvider, authenticatedUser, entityLabel, entityClass, entitiesLabel, entitiesClass);
        add(navigationContainer);
    }

    public long getSelectedEntityId() {
        return navigationContainer.getSelectedEntityId();
    }

    public void setSelectedEntityId(long selectedEntityId) {
        navigationContainer.setSelectedEntityId(selectedEntityId);
    }

    public void selectedEntityChanged(long selectedEntityId) {
        navigationContainer.selectedEntityChanged(selectedEntityId);
    }

    public void save() {
        navigationContainer.save();
    }

    public void cancel() {
        navigationContainer.cancel();
    }
}
