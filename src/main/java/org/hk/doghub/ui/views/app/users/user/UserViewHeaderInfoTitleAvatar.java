package org.hk.doghub.ui.views.app.users.user;

import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import org.hk.doghub.model.user.DogHubUser;
import org.hk.doghub.ui.components.shared.user.UserAvatar;
import org.hk.doghub.ui.views.app.users.UserDataProvider;

import java.util.Optional;

public class UserViewHeaderInfoTitleAvatar extends HorizontalLayout {

    public static final String CLASS_NAME = UserViewHeaderInfoTitle.CLASS_NAME + "-avatar";

    private final UserAvatar avatar;
    private final UserDataProvider userDataProvider;

    public UserViewHeaderInfoTitleAvatar(UserDataProvider userDataProvider) {
        this.userDataProvider = userDataProvider;
        addClassName(CLASS_NAME);
        avatar = new UserAvatar(null);
        add(avatar);
    }

    public void selectedUserChanged(long selectedUserId) {
        Optional<DogHubUser> user = userDataProvider.findById(selectedUserId);
        if(user.isPresent()) {
            avatar.selectedUserChanged(user.get());
        }
    }
}
