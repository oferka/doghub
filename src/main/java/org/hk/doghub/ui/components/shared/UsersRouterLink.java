package org.hk.doghub.ui.components.shared;

import com.vaadin.flow.router.RouterLink;
import org.hk.doghub.ui.views.app.users.UsersView;

public class UsersRouterLink extends RouterLink {

    public static final String CLASS_NAME = "users-router-link";

    public UsersRouterLink() {
        super("Users", UsersView.class);
        addClassName(CLASS_NAME);
    }
}
