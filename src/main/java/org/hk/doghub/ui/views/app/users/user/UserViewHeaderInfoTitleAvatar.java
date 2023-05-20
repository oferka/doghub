package org.hk.doghub.ui.views.app.users.user;

import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import org.hk.doghub.model.user.DogHubUser;
import org.hk.doghub.ui.components.shared.UserAvatar;
import org.hk.doghub.ui.views.app.users.UsersDataProvider;

import java.util.Optional;

public class UserViewHeaderInfoTitleAvatar extends HorizontalLayout {

    public static final String CLASS_NAME = UserViewHeaderInfoTitle.CLASS_NAME + "-avatar";

    private final UserAvatar userAvatar;
    private final UsersDataProvider usersDataProvider;

    public UserViewHeaderInfoTitleAvatar(UsersDataProvider usersDataProvider) {
        this.usersDataProvider = usersDataProvider;
        addClassName(CLASS_NAME);
        userAvatar = new UserAvatar(null);
        add(userAvatar);
    }

    public void selectedUserChanged(long selectedUserId) {
        Optional<DogHubUser> user = usersDataProvider.findById(selectedUserId);
        if(user.isPresent()) {
            userAvatar.selectedUserChanged(user.get());
        }
    }
}
