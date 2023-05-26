package org.hk.doghub.ui.views.app.users.create;

import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import org.hk.doghub.security.AuthenticatedUser;

public class UserCreationViewHeaderActions extends HorizontalLayout {

    public static final String CLASS_NAME = UserCreationViewHeader.CLASS_NAME + "-actions";

    private final UserCreationViewHeaderActionsShareButton share;
    private final UserCreationViewHeaderActionsExportButton export;

    public UserCreationViewHeaderActions(AuthenticatedUser authenticatedUser, UserCreationService userCreationService) {
        addClassName(CLASS_NAME);

        share = new UserCreationViewHeaderActionsShareButton(authenticatedUser, userCreationService);
        add(share);

        export = new UserCreationViewHeaderActionsExportButton(authenticatedUser, userCreationService);
        add(export);
    }
}
