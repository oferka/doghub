package org.hk.doghub.ui.views.app.users.user;

import com.vaadin.flow.router.RouterLink;
import org.hk.doghub.model.user.DogHubUser;
import org.hk.doghub.security.AuthenticatedUser;
import org.hk.doghub.ui.components.shared.PreviousEntityButton;
import org.hk.doghub.ui.views.app.users.UserDataProvider;

import java.util.Optional;

public class PreviousUserRouterLink extends RouterLink {

    public static final String CLASS_NAME = "previous-user-router-link";

    private final UserDataProvider userDataProvider;

    private final PreviousEntityButton previousEntityButton;

    private final AuthenticatedUser authenticatedUser;

    public PreviousUserRouterLink(UserDataProvider userDataProvider, AuthenticatedUser authenticatedUser) {
        this.userDataProvider = userDataProvider;
        this.authenticatedUser = authenticatedUser;
        addClassName(CLASS_NAME);

        previousEntityButton = new PreviousEntityButton("Previous User");
        previousEntityButton.setEnabled(false);
        add(previousEntityButton);
    }

    public void selectedUserChanged(long selectedUserId) {
        Optional<DogHubUser> userOptional = userDataProvider.findPrevious(authenticatedUser, selectedUserId);
        if(userOptional.isPresent()) {
            setRoute(UserView.class, userOptional.get().getId());
            previousEntityButton.setEnabled(true);
        }
        else {
            previousEntityButton.setEnabled(false);
        }
    }
}
