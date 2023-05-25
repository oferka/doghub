package org.hk.doghub.ui.views.app.users.user;

import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import org.hk.doghub.ui.views.app.users.UsersDataProvider;

import static com.vaadin.flow.component.orderedlayout.FlexComponent.Alignment.CENTER;

public class UserViewHeaderInfo extends VerticalLayout {

    public static final String CLASS_NAME = UserViewHeader.CLASS_NAME + "-info";

    private final UserViewHeaderInfoTitle title;
    private final UserViewHeaderInfoDescription description;

    public UserViewHeaderInfo(UsersDataProvider usersDataProvider) {
        addClassName(CLASS_NAME);

        setAlignItems(CENTER);

        title = new UserViewHeaderInfoTitle(usersDataProvider);
        add(title);

        description = new UserViewHeaderInfoDescription(usersDataProvider);
        add(description);
    }

    public void selectedUserChanged(long selectedUserId) {
        title.selectedUserChanged(selectedUserId);
        description.selectedUserChanged(selectedUserId);
    }
}
