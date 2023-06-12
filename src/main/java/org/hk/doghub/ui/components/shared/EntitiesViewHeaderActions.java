package org.hk.doghub.ui.components.shared;

import com.vaadin.flow.component.Component;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import jakarta.validation.constraints.NotNull;

public class EntitiesViewHeaderActions extends HorizontalLayout {

    public static final String CLASS_NAME = EntitiesViewHeader.CLASS_NAME + "-actions";

    public EntitiesViewHeaderActions(EntitiesViewState viewState, @NotNull Class<? extends Component> entityCreationNavigationTarget, @NotNull String entityName) {
        addClassName(CLASS_NAME);
        EntitiesViewHeaderActionsPresentationTypeSelector presentationTypeSelector = new EntitiesViewHeaderActionsPresentationTypeSelector(viewState);
        EntitiesViewHeaderActionsFilterButton filter = new EntitiesViewHeaderActionsFilterButton();
        EntitiesViewHeaderActionsNewRouterLink newRouterLink = new EntitiesViewHeaderActionsNewRouterLink(entityCreationNavigationTarget, entityName);
        add(presentationTypeSelector, filter, newRouterLink);
    }
}
