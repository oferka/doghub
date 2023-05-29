package org.hk.doghub.ui.views.app.users.user;

import com.vaadin.flow.router.RouterLink;
import org.hk.doghub.model.user.DogHubUser;
import org.hk.doghub.ui.views.app.users.UsersDataProvider;

import java.util.Optional;

public class NextUserRouterLink extends RouterLink {

    public static final String CLASS_NAME = "next-user-router-link";

    private final UsersDataProvider usersDataProvider;

    private final NextUserButton nextUserButton;

    public NextUserRouterLink(UsersDataProvider usersDataProvider) {
        this.usersDataProvider = usersDataProvider;
        addClassName(CLASS_NAME);

        nextUserButton = new NextUserButton();
        nextUserButton.setEnabled(false);
        add(nextUserButton);
    }

    public void selectedUserChanged(long selectedUserId) {
        Optional<DogHubUser> userOptional = usersDataProvider.findNext(selectedUserId);
        if(userOptional.isPresent()) {
            setRoute(UserView.class, userOptional.get().getId());
            nextUserButton.setEnabled(true);
        }
        else {
            nextUserButton.setEnabled(false);
        }
    }
}
