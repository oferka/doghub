package org.hk.doghub.ui.views.app.users;

import jakarta.validation.constraints.NotNull;
import org.hk.doghub.model.tip.DogHubTip;
import org.hk.doghub.model.user.DogHubUser;
import org.hk.doghub.ui.views.app.tips.TipsView;

public class UserTipsRouterLink extends UserEntitiesRouterLink<DogHubTip> {

    public static final String CLASS_NAME = "user-tips-router-link";

    public UserTipsRouterLink(DogHubUser user) {
        super(user, TipsView.class);
        addClassName(CLASS_NAME);
    }

    @Override
    protected @NotNull UserEntitiesAvatarGroup<DogHubTip> getAvatarGroup(@NotNull DogHubUser user) {
        return new UserTipsAvatarGroup(user);
    }
}
