package org.hk.doghub.ui.views.app.users;

import com.vaadin.flow.router.RouterLink;
import org.hk.doghub.model.user.DogHubUser;
import org.hk.doghub.ui.views.app.users.user.UserView;

public class UserNameRouterLink extends RouterLink {

    public static final String CLASS_NAME = "user-name-router-link";

    public UserNameRouterLink(DogHubUser user) {
        super(user.getName(), UserView.class, user.getId());
        addClassName(CLASS_NAME);
    }
}
