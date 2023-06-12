package org.hk.doghub.ui.components.shared.user;

import com.vaadin.flow.router.RouterLink;
import org.hk.doghub.model.user.DogHubUser;
import org.hk.doghub.ui.components.shared.EntityAvatar;
import org.hk.doghub.ui.views.app.users.user.UserView;

import static org.apache.commons.lang3.StringUtils.EMPTY;

public class UserAvatarRouterLink extends RouterLink {

    public static final String CLASS_NAME = "user-avatar-router-link";

    public UserAvatarRouterLink(DogHubUser user) {
        super(EMPTY, UserView.class, user.getId());
        addClassName(CLASS_NAME);
        EntityAvatar<DogHubUser> avatar = new EntityAvatar<>(user);
        add(avatar);
    }
}
