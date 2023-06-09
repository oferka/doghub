package org.hk.doghub.ui.views.app.users;

import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import org.hk.doghub.ui.components.shared.EntitiesViewHeaderActionsFilterButton;
import org.hk.doghub.ui.components.shared.EntitiesViewHeaderActionsNewRouterLink;
import org.hk.doghub.ui.components.shared.EntitiesViewHeaderActionsPresentationTypeSelector;
import org.hk.doghub.ui.components.shared.EntitiesViewState;
import org.hk.doghub.ui.views.app.users.create.UserCreationView;
import org.hk.doghub.ui.views.app.users.user.UserView;

public class UsersViewHeaderActions extends HorizontalLayout {

    public static final String CLASS_NAME = UsersViewHeader.CLASS_NAME + "-actions";

    private final EntitiesViewHeaderActionsPresentationTypeSelector presentationTypeSelector;
    private final EntitiesViewHeaderActionsFilterButton filter;
    private final EntitiesViewHeaderActionsNewRouterLink newRouterLink;

    public UsersViewHeaderActions(EntitiesViewState viewState) {
        addClassName(CLASS_NAME);

        presentationTypeSelector = new EntitiesViewHeaderActionsPresentationTypeSelector(viewState);
        add(presentationTypeSelector);

        filter = new EntitiesViewHeaderActionsFilterButton();
        add(filter);

        newRouterLink = new EntitiesViewHeaderActionsNewRouterLink(UserCreationView.class, UserView.NAME);
        add(newRouterLink);
    }
}
