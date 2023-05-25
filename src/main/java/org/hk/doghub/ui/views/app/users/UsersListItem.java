package org.hk.doghub.ui.views.app.users;

import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import org.hk.doghub.model.user.DogHubUser;

public class UsersListItem extends HorizontalLayout {

    public static final String CLASS_NAME = UsersList.CLASS_NAME + "-item";

    private final UsersListItemAvatar avatar;
    private final UsersListItemInfo info;

    public UsersListItem(DogHubUser user) {
        addClassName(CLASS_NAME);
        setSpacing(false);
        getThemeList().add("spacing-s");

        avatar = new UsersListItemAvatar(user);
        add(avatar);

        info = new UsersListItemInfo(user);
        add(info);
    }
}
