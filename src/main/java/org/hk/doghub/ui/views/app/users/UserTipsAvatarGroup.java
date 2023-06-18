package org.hk.doghub.ui.views.app.users;

import org.hk.doghub.model.tip.DogHubTip;
import org.hk.doghub.model.user.DogHubUser;

import java.util.List;

public class UserTipsAvatarGroup extends UserEntitiesAvatarGroup<DogHubTip> {

    public static final String CLASS_NAME = "user-tips-avatar-group";

    public UserTipsAvatarGroup(DogHubUser user) {
        super(user);
        addClassName(CLASS_NAME);
    }

    @Override
    protected List<DogHubTip> getEntities(DogHubUser user) {
        return user.getDogHubTips();
    }
}
