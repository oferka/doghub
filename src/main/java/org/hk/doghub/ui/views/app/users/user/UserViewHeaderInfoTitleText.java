package org.hk.doghub.ui.views.app.users.user;

import com.vaadin.flow.component.html.H2;
import org.hk.doghub.model.DogHubUser;
import org.hk.doghub.ui.views.app.users.UsersDataProvider;

import java.util.Optional;

public class UserViewHeaderInfoTitleText extends H2 {

    public static final String CLASS_NAME = UserViewHeaderInfoTitle.CLASS_NAME + "-text";

    private final UsersDataProvider usersDataProvider;

    public UserViewHeaderInfoTitleText(UsersDataProvider usersDataProvider) {
        this.usersDataProvider = usersDataProvider;
        addClassName(CLASS_NAME);
    }

    public void selectedUserChanged(long selectedUserId) {
        setText("Selected User: " + selectedUserId);
        Optional<DogHubUser> user = usersDataProvider.findById(selectedUserId);
        user.ifPresent(value -> setText(value.getName()));
    }
}
