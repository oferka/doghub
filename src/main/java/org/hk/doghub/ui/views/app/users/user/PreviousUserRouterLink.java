package org.hk.doghub.ui.views.app.users.user;

import com.vaadin.flow.router.RouterLink;
import org.hk.doghub.model.user.DogHubUser;
import org.hk.doghub.ui.components.shared.PreviousEntityButton;
import org.hk.doghub.ui.views.app.users.UserDataProvider;

import java.util.Optional;

public class PreviousUserRouterLink extends RouterLink {

    public static final String CLASS_NAME = "previous-user-router-link";

    private final UserDataProvider userDataProvider;

    private final PreviousEntityButton previousEntityButton;

    public PreviousUserRouterLink(UserDataProvider userDataProvider) {
        this.userDataProvider = userDataProvider;
        addClassName(CLASS_NAME);

        previousEntityButton = new PreviousEntityButton("Previous User");
        previousEntityButton.setEnabled(false);
        add(previousEntityButton);
    }

    public void selectedUserChanged(long selectedUserId) {
        Optional<DogHubUser> userOptional = userDataProvider.findPrevious(selectedUserId);
        if(userOptional.isPresent()) {
            setRoute(UserView.class, userOptional.get().getId());
            previousEntityButton.setEnabled(true);
        }
        else {
            previousEntityButton.setEnabled(false);
        }
    }
}
