package org.hk.doghub.ui.components.shared;

import com.vaadin.flow.component.Component;
import com.vaadin.flow.router.RouterLink;
import jakarta.validation.constraints.NotNull;

import static org.apache.commons.lang3.StringUtils.EMPTY;

public class EntitiesViewHeaderActionsNewRouterLink extends RouterLink {

    public static final String CLASS_NAME = EntitiesViewHeaderActions.CLASS_NAME + "-new-router-link";

    public EntitiesViewHeaderActionsNewRouterLink(@NotNull Class<? extends Component> entityCreationNavigationTarget, @NotNull String entityName) {
        super(EMPTY, entityCreationNavigationTarget);
        addClassName(CLASS_NAME);
        EntitiesViewHeaderActionsNewButton newButton = new EntitiesViewHeaderActionsNewButton(entityName);
        add(newButton);
    }
}
