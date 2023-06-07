package org.hk.doghub.ui.views.app.users.user;

import com.vaadin.flow.router.RouterLink;
import org.hk.doghub.model.user.DogHubUser;
import org.hk.doghub.security.AuthenticatedUser;
import org.hk.doghub.ui.components.shared.NextEntityButton;
import org.hk.doghub.ui.views.app.users.UserDataProvider;

import java.util.Optional;

public class NextUserRouterLink extends RouterLink {

    public static final String CLASS_NAME = "next-user-router-link";

    private final UserDataProvider userDataProvider;

    private final NextEntityButton nextEntityButton;

    private final AuthenticatedUser authenticatedUser;

    public NextUserRouterLink(UserDataProvider userDataProvider, AuthenticatedUser authenticatedUser) {
        this.userDataProvider = userDataProvider;
        this.authenticatedUser = authenticatedUser;
        addClassName(CLASS_NAME);

        nextEntityButton = new NextEntityButton("Next User");
        nextEntityButton.setEnabled(false);
        add(nextEntityButton);
    }

    public void selectedUserChanged(long selectedUserId) {
        Optional<DogHubUser> userOptional = userDataProvider.findNext(authenticatedUser, selectedUserId);
        if(userOptional.isPresent()) {
            setRoute(UserView.class, userOptional.get().getId());
            nextEntityButton.setEnabled(true);
        }
        else {
            nextEntityButton.setEnabled(false);
        }
    }
}
