package org.hk.doghub.ui.views.app.users;

import com.vaadin.flow.component.avatar.AvatarGroup;
import org.hk.doghub.model.dog.DogHubDog;
import org.hk.doghub.model.user.DogHubUser;

import java.util.List;

public class UserDogsAvatarGroup extends AvatarGroup {

    public static final String CLASS_NAME = "user-dogs-avatar-group";

    public UserDogsAvatarGroup(DogHubUser user) {
        addClassName(CLASS_NAME);
        List<DogHubDog> dogs = user.getDogHubDogs();
        int colorIndex = 0;
        for (DogHubDog dog : dogs) {
            AvatarGroup.AvatarGroupItem avatarGroupItem = new AvatarGroup.AvatarGroupItem(dog.getName());
            avatarGroupItem.setColorIndex(colorIndex++);
            add(avatarGroupItem);
        }
        setMaxItemsVisible(5);
    }
}
