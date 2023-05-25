package org.hk.doghub.ui.views.app.users.user;

import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import org.hk.doghub.ui.views.app.users.UsersDataProvider;

import static com.vaadin.flow.component.orderedlayout.FlexComponent.Alignment.CENTER;

public class UserViewHeaderInfoTitle extends HorizontalLayout {

    public static final String CLASS_NAME = UserViewHeaderInfo.CLASS_NAME + "-title";

    private final UserViewHeaderInfoTitleAvatar avatar;
    private final UserViewHeaderInfoTitleText text;

    public UserViewHeaderInfoTitle(UsersDataProvider usersDataProvider) {
        addClassName(CLASS_NAME);

        setAlignItems(CENTER);

        avatar = new UserViewHeaderInfoTitleAvatar(usersDataProvider);
        add(avatar);

        text = new UserViewHeaderInfoTitleText(usersDataProvider);
        add(text);

        setVerticalComponentAlignment(CENTER, avatar, text);
    }

    public void selectedUserChanged(long selectedUserId) {
        avatar.selectedUserChanged(selectedUserId);
        text.selectedUserChanged(selectedUserId);
    }
}
