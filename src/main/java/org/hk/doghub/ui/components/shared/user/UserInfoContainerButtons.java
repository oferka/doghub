package org.hk.doghub.ui.components.shared.user;

import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import org.hk.doghub.security.AuthenticatedUser;
import org.hk.doghub.ui.views.app.users.UsersDataProvider;

public class UserInfoContainerButtons extends HorizontalLayout {

    public static final String CLASS_NAME = UserInfoContainer.CLASS_NAME + "-buttons";

    private final UserInfoSaveButton save;

    private final UserInfoCancelButton cancel;

    public UserInfoContainerButtons(UsersDataProvider usersDataProvider, AuthenticatedUser authenticatedUser, UserCreationService userCreationService) {
        addClassName(CLASS_NAME);

        save = new UserInfoSaveButton();
        add(save);

        cancel = new UserInfoCancelButton();
        add(cancel);
    }

    public void addUserInfoSaveListener(UserInfoSaveListener listener) {
        save.addUserInfoSaveListener(listener);
    }

    public void removeUserInfoSaveListener(UserInfoSaveListener listener) {
        save.removeUserInfoSaveListener(listener);
    }

    public void addUserInfoCancelListener(UserInfoCancelListener listener) {
        cancel.addUserInfoCancelListener(listener);
    }

    public void removeUserInfoCancelListener(UserInfoCancelListener listener) {
        cancel.removeUserInfoCancelListener(listener);
    }
}
