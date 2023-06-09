package org.hk.doghub.ui.views.app.users;

import com.vaadin.flow.router.RouterLink;
import org.hk.doghub.ui.components.shared.EntitiesViewHeaderActionsNewButton;
import org.hk.doghub.ui.views.app.users.create.UserCreationView;
import org.hk.doghub.ui.views.app.users.user.UserView;

import static org.apache.commons.lang3.StringUtils.EMPTY;

public class UsersViewHeaderActionsNewRouterLink extends RouterLink {

    public static final String CLASS_NAME = UsersViewHeaderActions.CLASS_NAME + "-new-router-link";

    private final EntitiesViewHeaderActionsNewButton newButton;

    public UsersViewHeaderActionsNewRouterLink() {
        super(EMPTY, UserCreationView.class);
        addClassName(CLASS_NAME);

        newButton = new EntitiesViewHeaderActionsNewButton(UserView.NAME);
        add(newButton);
    }
}
