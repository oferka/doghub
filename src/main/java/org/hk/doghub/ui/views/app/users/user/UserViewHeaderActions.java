package org.hk.doghub.ui.views.app.users.user;

import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import org.hk.doghub.model.user.DogHubUser;
import org.hk.doghub.ui.components.shared.EntityViewHeaderActionsExportButton;
import org.hk.doghub.ui.components.shared.EntityViewHeaderActionsShareButton;
import org.hk.doghub.ui.views.app.users.UserDataProvider;

public class UserViewHeaderActions extends HorizontalLayout {

    public static final String CLASS_NAME = UserViewHeader.CLASS_NAME + "-actions";

    private final EntityViewHeaderActionsShareButton<DogHubUser> share;
    private final EntityViewHeaderActionsExportButton<DogHubUser> export;

    public UserViewHeaderActions(UserDataProvider userDataProvider) {
        addClassName(CLASS_NAME);

        share = new EntityViewHeaderActionsShareButton<>(userDataProvider);
        add(share);

        export = new EntityViewHeaderActionsExportButton<>(userDataProvider);
        add(export);
    }

    public void selectedUserChanged(long selectedUserId) {
        share.selectedEntityChanged(selectedUserId);
        export.selectedEntityChanged(selectedUserId);
    }
}
