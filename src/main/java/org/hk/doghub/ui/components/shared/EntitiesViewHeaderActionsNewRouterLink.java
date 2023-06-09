package org.hk.doghub.ui.components.shared;

import com.vaadin.flow.component.Component;
import com.vaadin.flow.router.RouterLink;
import jakarta.validation.constraints.NotNull;

import static org.apache.commons.lang3.StringUtils.EMPTY;

public class EntitiesViewHeaderActionsNewRouterLink extends RouterLink {

    public static final String CLASS_NAME = "entities-view-header-actions-new-router-link";

    private final EntitiesViewHeaderActionsNewButton newButton;

    public EntitiesViewHeaderActionsNewRouterLink(@NotNull Class<? extends Component> navigationTarget, @NotNull String entityName) {
        super(EMPTY, navigationTarget);
        addClassName(CLASS_NAME);
        newButton = new EntitiesViewHeaderActionsNewButton(entityName);
        add(newButton);
    }
}
