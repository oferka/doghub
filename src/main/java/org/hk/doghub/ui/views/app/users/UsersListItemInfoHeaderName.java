package org.hk.doghub.ui.views.app.users;

import com.vaadin.flow.component.html.Div;
import org.hk.doghub.model.user.DogHubUser;

public class UsersListItemInfoHeaderName extends Div {

    public static final String CLASS_NAME = UsersListItemInfoHeader.CLASS_NAME + "-name";

    private final UserRouterLink link;

    public UsersListItemInfoHeaderName(DogHubUser user) {
        addClassName(CLASS_NAME);
        link = new UserRouterLink(user);
        add(link);
    }
}
