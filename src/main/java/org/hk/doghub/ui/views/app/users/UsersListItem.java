package org.hk.doghub.ui.views.app.users;

import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import org.hk.doghub.model.user.DogHubUser;
import org.hk.doghub.security.AuthenticatedUser;
import org.hk.doghub.ui.components.shared.EntitiesListItemAvatar;

public class UsersListItem extends HorizontalLayout {

    public static final String CLASS_NAME = UsersList.CLASS_NAME + "-item";

    private final EntitiesListItemAvatar<DogHubUser> avatar;
    private final UsersListItemInfo info;

    public UsersListItem(DogHubUser user, AuthenticatedUser authenticatedUser) {
        addClassName(CLASS_NAME);
        setSpacing(false);
        getThemeList().add("spacing-s");

        avatar = new EntitiesListItemAvatar<>(user);
        add(avatar);

        info = new UsersListItemInfo(user, authenticatedUser);
        add(info);
    }
}
