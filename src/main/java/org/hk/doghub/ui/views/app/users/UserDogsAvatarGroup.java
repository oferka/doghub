package org.hk.doghub.ui.views.app.users;

import org.hk.doghub.model.dog.DogHubDog;
import org.hk.doghub.model.user.DogHubUser;

import java.util.List;

public class UserDogsAvatarGroup extends UserEntitiesAvatarGroup<DogHubDog> {

    public static final String CLASS_NAME = "user-dogs-avatar-group";

    public UserDogsAvatarGroup(DogHubUser user) {
        super(user);
        addClassName(CLASS_NAME);
    }

    @Override
    protected List<DogHubDog> getEntities(DogHubUser user) {
        return user.getDogHubDogs();
    }
}
