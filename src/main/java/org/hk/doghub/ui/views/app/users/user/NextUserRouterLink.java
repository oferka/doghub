package org.hk.doghub.ui.views.app.users.user;

import com.vaadin.flow.router.RouterLink;
import org.hk.doghub.model.user.DogHubUser;
import org.hk.doghub.ui.views.app.users.UsersDataProvider;

import java.util.Optional;

public class NextUserRouterLink extends RouterLink {

    public static final String CLASS_NAME = "next-user-router-link";

    private final UsersDataProvider usersDataProvider;

    public NextUserRouterLink(UsersDataProvider usersDataProvider) {
        this.usersDataProvider = usersDataProvider;
        addClassName(CLASS_NAME);
        setText("Next User");
        setEnabled(false);
    }

    public void selectedUserChanged(long selectedUserId) {
        Optional<DogHubUser> userOptional = usersDataProvider.findNext(selectedUserId);
        if(userOptional.isPresent()) {
            setRoute(UserView.class, userOptional.get().getId());
            setEnabled(true);
        }
        else {
            setEnabled(false);
        }
    }
}
