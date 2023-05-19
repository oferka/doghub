package org.hk.doghub.ui.views.app.users.user;

import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import org.hk.doghub.ui.views.app.users.UsersDataProvider;

import static com.vaadin.flow.component.orderedlayout.FlexComponent.Alignment.CENTER;

public class UserViewHeaderInfoTitle extends HorizontalLayout {

    public static final String CLASS_NAME = UserViewHeaderInfo.CLASS_NAME + "-title";

    private final UserViewHeaderInfoTitleAvatar userViewHeaderInfoTitleIcon;
    private final UserViewHeaderInfoTitleText userViewHeaderInfoTitleText;

    public UserViewHeaderInfoTitle(UsersDataProvider usersDataProvider) {
        addClassName(CLASS_NAME);

        setAlignItems(CENTER);

        userViewHeaderInfoTitleIcon = new UserViewHeaderInfoTitleAvatar(usersDataProvider);
        add(userViewHeaderInfoTitleIcon);

        userViewHeaderInfoTitleText = new UserViewHeaderInfoTitleText(usersDataProvider);
        add(userViewHeaderInfoTitleText);

        setVerticalComponentAlignment(CENTER, userViewHeaderInfoTitleIcon, userViewHeaderInfoTitleText);
    }

    public void selectedUserChanged(long selectedUserId) {
        userViewHeaderInfoTitleIcon.selectedUserChanged(selectedUserId);
        userViewHeaderInfoTitleText.selectedUserChanged(selectedUserId);
    }
}
