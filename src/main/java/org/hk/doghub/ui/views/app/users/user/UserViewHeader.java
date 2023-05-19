package org.hk.doghub.ui.views.app.users.user;

import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import org.hk.doghub.ui.views.app.users.UsersDataProvider;

import static com.vaadin.flow.component.orderedlayout.FlexComponent.Alignment.CENTER;

public class UserViewHeader extends HorizontalLayout {

    public static final String CLASS_NAME = UserView.CLASS_NAME + "-header";

    private final UserViewHeaderInfo userViewHeaderInfo;
    private final UserViewHeaderActions userViewHeaderActions;

    public UserViewHeader(UsersDataProvider usersDataProvider) {
        addClassName(CLASS_NAME);

        setWidthFull();
        setAlignItems(CENTER);

        userViewHeaderInfo = new UserViewHeaderInfo(usersDataProvider);
        add(userViewHeaderInfo);

        userViewHeaderActions = new UserViewHeaderActions(usersDataProvider);
        add(userViewHeaderActions);
    }

    public void selectedUserChanged(long selectedUserId) {
        userViewHeaderInfo.selectedUserChanged(selectedUserId);
        userViewHeaderActions.selectedUserChanged(selectedUserId);
    }
}
