package org.hk.doghub.ui.views.app.users.user;

import com.vaadin.flow.component.html.H2;
import org.hk.doghub.model.user.DogHubUser;
import org.hk.doghub.ui.views.app.users.UserDataProvider;

import java.util.Optional;

public class UserViewHeaderInfoTitleText extends H2 {

    public static final String CLASS_NAME = UserViewHeaderInfoTitle.CLASS_NAME + "-text";

    private final UserDataProvider userDataProvider;

    public UserViewHeaderInfoTitleText(UserDataProvider userDataProvider) {
        this.userDataProvider = userDataProvider;
        addClassName(CLASS_NAME);
    }

    public void selectedUserChanged(long selectedUserId) {
        setText("Selected User: " + selectedUserId);
        Optional<DogHubUser> user = userDataProvider.findById(selectedUserId);
        user.ifPresent(value -> setText(value.getName()));
    }
}
