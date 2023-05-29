package org.hk.doghub.ui.views.app.users.user;

import com.vaadin.flow.router.RouterLink;
import org.hk.doghub.model.user.DogHubUser;
import org.hk.doghub.ui.views.app.users.UsersDataProvider;

import java.util.Optional;

public class PreviousUserRouterLink extends RouterLink {

    public static final String CLASS_NAME = "previous-user-router-link";

    private final UsersDataProvider usersDataProvider;

    private final PreviousUserButton previousUserButton;

    public PreviousUserRouterLink(UsersDataProvider usersDataProvider) {
        this.usersDataProvider = usersDataProvider;
        addClassName(CLASS_NAME);

        previousUserButton = new PreviousUserButton();
        previousUserButton.setEnabled(false);
        add(previousUserButton);
    }

    public void selectedUserChanged(long selectedUserId) {
        Optional<DogHubUser> userOptional = usersDataProvider.findPrevious(selectedUserId);
        if(userOptional.isPresent()) {
            setRoute(UserView.class, userOptional.get().getId());
            previousUserButton.setEnabled(true);
        }
        else {
            previousUserButton.setEnabled(false);
        }
    }
}
