package org.hk.doghub.ui.views.app.users.create;

import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import org.hk.doghub.security.AuthenticatedUser;
import org.hk.doghub.ui.components.shared.user.UserCreationService;

public class UserCreationViewHeaderActions extends HorizontalLayout {

    public static final String CLASS_NAME = UserCreationViewHeader.CLASS_NAME + "-actions";

    public UserCreationViewHeaderActions(AuthenticatedUser authenticatedUser, UserCreationService userCreationService) {
        addClassName(CLASS_NAME);
        UserCreationViewHeaderActionsShareButton share = new UserCreationViewHeaderActionsShareButton(authenticatedUser, userCreationService);
        UserCreationViewHeaderActionsExportButton export = new UserCreationViewHeaderActionsExportButton(authenticatedUser, userCreationService);
        add(share, export);
    }
}
