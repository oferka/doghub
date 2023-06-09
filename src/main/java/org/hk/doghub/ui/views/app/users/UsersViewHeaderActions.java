package org.hk.doghub.ui.views.app.users;

import com.vaadin.flow.component.orderedlayout.HorizontalLayout;

public class UsersViewHeaderActions extends HorizontalLayout {

    public static final String CLASS_NAME = UsersViewHeader.CLASS_NAME + "-actions";

    private final UsersViewHeaderActionsPresentationTypeSelector presentationTypeSelector;
    private final UsersViewHeaderActionsFilterButton filter;
    private final UsersViewHeaderActionsNewRouterLink newRouterLink;

    public UsersViewHeaderActions(UserDataProvider usersViewDataProvider, UsersViewState usersViewState) {
        addClassName(CLASS_NAME);

        presentationTypeSelector = new UsersViewHeaderActionsPresentationTypeSelector(usersViewState);
        add(presentationTypeSelector);

        filter = new UsersViewHeaderActionsFilterButton(usersViewDataProvider, usersViewState);
        add(filter);

        newRouterLink = new UsersViewHeaderActionsNewRouterLink(usersViewDataProvider, usersViewState);
        add(newRouterLink);
    }
}
