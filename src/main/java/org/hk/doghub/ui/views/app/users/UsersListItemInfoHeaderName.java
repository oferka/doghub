package org.hk.doghub.ui.views.app.users;

import com.vaadin.flow.component.html.Div;
import org.hk.doghub.model.user.DogHubUser;
import org.hk.doghub.ui.components.shared.EntityRouterLink;
import org.hk.doghub.ui.views.app.users.user.UserView;

public class UsersListItemInfoHeaderName extends Div {

    public static final String CLASS_NAME = UsersListItemInfoHeader.CLASS_NAME + "-name";

    private final EntityRouterLink<DogHubUser> link;

    public UsersListItemInfoHeaderName(DogHubUser user) {
        addClassName(CLASS_NAME);
        link = new EntityRouterLink<>(user, UserView.class);
        add(link);
    }
}
