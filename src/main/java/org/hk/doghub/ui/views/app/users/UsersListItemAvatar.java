package org.hk.doghub.ui.views.app.users;

import com.vaadin.flow.component.html.Div;
import org.hk.doghub.model.DogHubUser;
import org.hk.doghub.ui.components.shared.UserAvatar;

public class UsersListItemAvatar extends Div {

    public static final String CLASS_NAME = UsersListItem.CLASS_NAME + "-avatar";

    private final UserAvatar userAvatar;

    public UsersListItemAvatar(DogHubUser user) {
        addClassNames(CLASS_NAME);
        userAvatar = new UserAvatar(user);
        add(userAvatar);
    }
}
