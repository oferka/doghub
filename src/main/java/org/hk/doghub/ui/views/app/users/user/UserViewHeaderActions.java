package org.hk.doghub.ui.views.app.users.user;

import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import org.hk.doghub.ui.views.app.users.UsersDataProvider;

public class UserViewHeaderActions extends HorizontalLayout {

    public static final String CLASS_NAME = UserViewHeader.CLASS_NAME + "-actions";

    private final UserViewHeaderActionsShareButton share;
    private final UserViewHeaderActionsExportButton export;

    public UserViewHeaderActions(UsersDataProvider usersDataProvider) {
        addClassName(CLASS_NAME);

        share = new UserViewHeaderActionsShareButton(usersDataProvider);
        add(share);

        export = new UserViewHeaderActionsExportButton(usersDataProvider);
        add(export);
    }

    public void selectedUserChanged(long selectedUserId) {
        share.selectedUserChanged(selectedUserId);
        export.selectedUserChanged(selectedUserId);
    }
}
