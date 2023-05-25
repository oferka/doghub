package org.hk.doghub.ui.components.shared;

import com.vaadin.flow.router.RouterLink;
import org.hk.doghub.model.user.DogHubUser;
import org.hk.doghub.ui.views.app.users.user.UserView;

import static org.apache.commons.lang3.StringUtils.EMPTY;

public class UserAvatarRouterLink extends RouterLink {

    public static final String CLASS_NAME = "user-avatar-router-link";

    private final UserAvatar avatar;

    public UserAvatarRouterLink(DogHubUser user) {
        super(EMPTY, UserView.class, user.getId());
        addClassName(CLASS_NAME);

        avatar = new UserAvatar(user);
        add(avatar);
    }
}
