package org.hk.doghub.ui.components.shared;

import com.vaadin.flow.component.Component;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import jakarta.validation.constraints.NotNull;

public class EntitiesViewHeaderActions extends HorizontalLayout {

    public static final String CLASS_NAME = "entities-view-header-actions";

    private final EntitiesViewHeaderActionsPresentationTypeSelector presentationTypeSelector;
    private final EntitiesViewHeaderActionsFilterButton filter;
    private final EntitiesViewHeaderActionsNewRouterLink newRouterLink;

    public EntitiesViewHeaderActions(EntitiesViewState viewState, @NotNull Class<? extends Component> entityCreationNavigationTarget, @NotNull String entityName) {
        addClassName(CLASS_NAME);

        presentationTypeSelector = new EntitiesViewHeaderActionsPresentationTypeSelector(viewState);
        add(presentationTypeSelector);

        filter = new EntitiesViewHeaderActionsFilterButton();
        add(filter);

        newRouterLink = new EntitiesViewHeaderActionsNewRouterLink(entityCreationNavigationTarget, entityName);
        add(newRouterLink);
    }
}
