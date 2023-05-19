package org.hk.doghub.ui.views.app.users.user;

import com.vaadin.flow.component.html.Span;
import org.hk.doghub.model.DogHubUser;
import org.hk.doghub.ui.views.app.users.UsersDataProvider;

import java.util.Optional;

public class UserViewHeaderInfoDescription extends Span {

    public static final String CLASS_NAME = UserViewHeaderInfo.CLASS_NAME + "-description";

    private final UsersDataProvider usersDataProvider;

    public UserViewHeaderInfoDescription(UsersDataProvider usersDataProvider) {
        this.usersDataProvider = usersDataProvider;
        addClassName(CLASS_NAME);
    }

    public void selectedUserChanged(long selectedUserId) {
        Optional<DogHubUser> user = usersDataProvider.findById(selectedUserId);
        user.ifPresent(value -> setText("Selected User Name: " + value.getName()));
    }
}
