package org.hk.doghub.ui.views.app.users.user;

import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import org.hk.doghub.ui.views.app.users.UsersDataProvider;

public class UserViewHeaderActions extends HorizontalLayout {

    public static final String CLASS_NAME = UserViewHeader.CLASS_NAME + "-actions";

    private final UserViewHeaderActionsShareButton userViewHeaderActionsShareButton;
    private final UserViewHeaderActionsExportButton userViewHeaderActionsExportButton;

    public UserViewHeaderActions(UsersDataProvider usersDataProvider) {
        addClassName(CLASS_NAME);

        userViewHeaderActionsShareButton = new UserViewHeaderActionsShareButton(usersDataProvider);
        add(userViewHeaderActionsShareButton);

        userViewHeaderActionsExportButton = new UserViewHeaderActionsExportButton(usersDataProvider);
        add(userViewHeaderActionsExportButton);
    }

    public void selectedUserChanged(long selectedUserId) {
        userViewHeaderActionsShareButton.selectedUserChanged(selectedUserId);
        userViewHeaderActionsExportButton.selectedUserChanged(selectedUserId);
    }
}
