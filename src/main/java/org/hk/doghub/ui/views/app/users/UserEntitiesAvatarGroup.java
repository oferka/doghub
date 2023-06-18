package org.hk.doghub.ui.views.app.users;

import com.vaadin.flow.component.avatar.AvatarGroup;
import org.hk.doghub.model.NamedEntity;
import org.hk.doghub.model.user.DogHubUser;

import java.util.List;

public abstract class UserEntitiesAvatarGroup<T extends NamedEntity> extends AvatarGroup {

    public static final String CLASS_NAME = "user-entities-avatar-group";

    public UserEntitiesAvatarGroup(DogHubUser user) {
        addClassName(CLASS_NAME);
        List<T> entities = getEntities(user);
        int colorIndex = 0;
        for (T entity : entities) {
            AvatarGroupItem avatarGroupItem = new AvatarGroupItem(entity.getName());
            avatarGroupItem.setColorIndex(colorIndex++);
            add(avatarGroupItem);
        }
        setMaxItemsVisible(5);
    }

    protected abstract List<T> getEntities(DogHubUser user);
}
