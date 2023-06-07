package org.hk.doghub.ui.views.app.users;

import com.vaadin.flow.component.html.Div;
import org.hk.doghub.model.user.DogHubUser;
import org.hk.doghub.ui.components.shared.EntityAvatar;

public class UsersListItemAvatar extends Div {

    public static final String CLASS_NAME = UsersListItem.CLASS_NAME + "-avatar";

    private final EntityAvatar<DogHubUser> avatar;

    public UsersListItemAvatar(DogHubUser user) {
        addClassNames(CLASS_NAME);
        avatar = new EntityAvatar<>(user);
        add(avatar);
    }
}
