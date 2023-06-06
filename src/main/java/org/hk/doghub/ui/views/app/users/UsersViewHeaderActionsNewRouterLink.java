package org.hk.doghub.ui.views.app.users;

import com.vaadin.flow.router.RouterLink;
import org.hk.doghub.ui.views.app.users.create.UserCreationView;

import static org.apache.commons.lang3.StringUtils.EMPTY;

public class UsersViewHeaderActionsNewRouterLink extends RouterLink {

    public static final String CLASS_NAME = UsersViewHeaderActions.CLASS_NAME + "-new-router-link";

    private final UsersViewHeaderActionsNewButton newButton;

    public UsersViewHeaderActionsNewRouterLink(UserDataProvider usersViewDataProvider, UsersViewState usersViewState) {
        super(EMPTY, UserCreationView.class);
        addClassName(CLASS_NAME);

        newButton = new UsersViewHeaderActionsNewButton(usersViewDataProvider, usersViewState);
        add(newButton);
    }
}
