package org.hk.doghub.ui.views.app.users;

import com.vaadin.flow.router.RouterLink;
import org.hk.doghub.model.DogHubUser;
import org.hk.doghub.ui.views.app.tips.TipsView;

import static org.apache.commons.lang3.StringUtils.EMPTY;

public class UserTipsRouterLink extends RouterLink {

    public static final String CLASS_NAME = "user-tips-router-link";

    private final UserTipsAvatarGroup userTipsAvatarGroup;

    public UserTipsRouterLink(DogHubUser user) {
        super(EMPTY, TipsView.class);
        addClassName(CLASS_NAME);

        userTipsAvatarGroup = new UserTipsAvatarGroup(user);
        add(userTipsAvatarGroup);
    }
}
