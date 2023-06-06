package org.hk.doghub.ui.views.app.users.user;

import com.vaadin.flow.component.html.Span;
import org.hk.doghub.model.user.DogHubUser;
import org.hk.doghub.ui.views.app.users.UserDataProvider;

import java.util.Optional;

public class UserViewHeaderInfoDescription extends Span {

    public static final String CLASS_NAME = UserViewHeaderInfo.CLASS_NAME + "-description";

    private final UserDataProvider userDataProvider;

    public UserViewHeaderInfoDescription(UserDataProvider userDataProvider) {
        this.userDataProvider = userDataProvider;
        addClassName(CLASS_NAME);
    }

    public void selectedUserChanged(long selectedUserId) {
        Optional<DogHubUser> user = userDataProvider.findById(selectedUserId);
        user.ifPresent(value -> setText("Selected User Name: " + value.getName()));
    }
}
