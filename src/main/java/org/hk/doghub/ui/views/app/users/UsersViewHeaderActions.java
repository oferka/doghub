package org.hk.doghub.ui.views.app.users;

import com.vaadin.flow.component.orderedlayout.HorizontalLayout;

public class UsersViewHeaderActions extends HorizontalLayout {

    public static final String CLASS_NAME = UsersViewHeader.CLASS_NAME + "-actions";

    private final UsersViewHeaderActionsPresentationTypeSelector usersViewHeaderActionsPresentationTypeSelector;
    private final UsersViewHeaderActionsFilterButton usersViewHeaderActionsFilterButton;
    private final UsersViewHeaderActionsNewRouterLink usersViewHeaderActionsNewRouterLink;

    public UsersViewHeaderActions(UsersDataProvider usersViewDataProvider, UsersViewState usersViewState) {
        addClassName(CLASS_NAME);

        usersViewHeaderActionsPresentationTypeSelector = new UsersViewHeaderActionsPresentationTypeSelector(usersViewDataProvider, usersViewState);
        add(usersViewHeaderActionsPresentationTypeSelector);

        usersViewHeaderActionsFilterButton = new UsersViewHeaderActionsFilterButton(usersViewDataProvider, usersViewState);
        add(usersViewHeaderActionsFilterButton);

        usersViewHeaderActionsNewRouterLink = new UsersViewHeaderActionsNewRouterLink(usersViewDataProvider, usersViewState);
        add(usersViewHeaderActionsNewRouterLink);
    }
}
