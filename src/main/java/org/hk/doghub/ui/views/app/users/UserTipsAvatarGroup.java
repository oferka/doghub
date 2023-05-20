package org.hk.doghub.ui.views.app.users;

import com.vaadin.flow.component.avatar.AvatarGroup;
import org.hk.doghub.model.tip.DogHubTip;
import org.hk.doghub.model.user.DogHubUser;

import java.util.List;

public class UserTipsAvatarGroup extends AvatarGroup {

    public static final String CLASS_NAME = "user-tips-avatar-group";

    public UserTipsAvatarGroup(DogHubUser user) {
        addClassName(CLASS_NAME);
        List<DogHubTip> tips = user.getDogHubTips();
        int colorIndex = 0;
        for (DogHubTip tip : tips) {
            AvatarGroup.AvatarGroupItem avatarGroupItem = new AvatarGroup.AvatarGroupItem(tip.getName());
            avatarGroupItem.setColorIndex(colorIndex++);
            add(avatarGroupItem);
        }
        setMaxItemsVisible(5);
    }
}
