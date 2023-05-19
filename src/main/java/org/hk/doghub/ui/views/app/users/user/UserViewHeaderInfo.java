package org.hk.doghub.ui.views.app.users.user;

import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import org.hk.doghub.ui.views.app.users.UsersDataProvider;

import static com.vaadin.flow.component.orderedlayout.FlexComponent.Alignment.CENTER;

public class UserViewHeaderInfo extends VerticalLayout {

    public static final String CLASS_NAME = UserViewHeader.CLASS_NAME + "-info";

    private final UserViewHeaderInfoTitle userViewHeaderInfoTitle;
    private final UserViewHeaderInfoDescription userViewHeaderInfoDescription;

    public UserViewHeaderInfo(UsersDataProvider usersDataProvider) {
        addClassName(CLASS_NAME);

        setAlignItems(CENTER);

        userViewHeaderInfoTitle = new UserViewHeaderInfoTitle(usersDataProvider);
        add(userViewHeaderInfoTitle);

        userViewHeaderInfoDescription = new UserViewHeaderInfoDescription(usersDataProvider);
        add(userViewHeaderInfoDescription);
    }

    public void selectedUserChanged(long selectedUserId) {
        userViewHeaderInfoTitle.selectedUserChanged(selectedUserId);
        userViewHeaderInfoDescription.selectedUserChanged(selectedUserId);
    }
}
