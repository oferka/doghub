package org.hk.doghub.ui.views.app.users;

import com.vaadin.flow.router.RouterLink;
import org.hk.doghub.model.DogHubUser;
import org.hk.doghub.ui.views.app.users.user.UserView;

public class UserIdRouterLink extends RouterLink {

    public static final String CLASS_NAME = "user-id-router-link";

    public UserIdRouterLink(DogHubUser user) {
        super(user.getId().toString(), UserView.class, user.getId());
        addClassName(CLASS_NAME);
    }
}
