package org.hk.doghub.ui.views.app.users;

import jakarta.validation.constraints.NotNull;
import org.hk.doghub.model.dog.DogHubDog;
import org.hk.doghub.model.user.DogHubUser;
import org.hk.doghub.ui.views.app.dogs.DogsView;

public class UserDogsRouterLink extends UserEntitiesRouterLink<DogHubDog> {

    public static final String CLASS_NAME = "user-dogs-router-link";

    public UserDogsRouterLink(DogHubUser user) {
        super(user, DogsView.class);
        addClassName(CLASS_NAME);
    }

    @Override
    protected @NotNull UserEntitiesAvatarGroup<DogHubDog> getAvatarGroup(@NotNull DogHubUser user) {
        return new UserDogsAvatarGroup(user);
    }
}
