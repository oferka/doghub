package org.hk.doghub.ui.views.app.users;

import com.vaadin.flow.router.RouterLink;
import org.hk.doghub.model.user.DogHubUser;
import org.hk.doghub.ui.views.app.dogs.DogsView;

import static org.apache.commons.lang3.StringUtils.EMPTY;

public class UserDogsRouterLink extends RouterLink {

    public static final String CLASS_NAME = "user-dogs-router-link";

    public UserDogsRouterLink(DogHubUser user) {
        super(EMPTY, DogsView.class);
        addClassName(CLASS_NAME);
        UserDogsAvatarGroup avatarGroup = new UserDogsAvatarGroup(user);
        add(avatarGroup);
    }
}
