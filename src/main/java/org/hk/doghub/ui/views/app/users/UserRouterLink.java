package org.hk.doghub.ui.views.app.users;

import com.vaadin.flow.router.RouterLink;
import org.hk.doghub.model.DogHubUser;
import org.hk.doghub.ui.views.app.users.user.UserView;

public class UserRouterLink extends RouterLink {

    public static final String CLASS_NAME = "user-router-link";

    public UserRouterLink(DogHubUser user) {
        super(user.getName(), UserView.class, user.getId());
        addClassName(CLASS_NAME);
    }
}
