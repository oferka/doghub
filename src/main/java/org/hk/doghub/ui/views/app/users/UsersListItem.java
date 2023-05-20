package org.hk.doghub.ui.views.app.users;

import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import org.hk.doghub.model.user.DogHubUser;

public class UsersListItem extends HorizontalLayout {

    public static final String CLASS_NAME = UsersList.CLASS_NAME + "-item";

    private final UsersListItemAvatar userListItemAvatar;
    private final UsersListItemInfo userListItemInfo;

    public UsersListItem(DogHubUser user) {
        addClassName(CLASS_NAME);
        setSpacing(false);
        getThemeList().add("spacing-s");

        userListItemAvatar = new UsersListItemAvatar(user);
        add(userListItemAvatar);

        userListItemInfo = new UsersListItemInfo(user);
        add(userListItemInfo);
    }
}
