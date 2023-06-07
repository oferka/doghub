package org.hk.doghub.ui.views.app.users.user;

import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import org.hk.doghub.model.user.DogHubUser;
import org.hk.doghub.ui.components.shared.EntityViewHeaderInfoTitle;
import org.hk.doghub.ui.views.app.users.UserDataProvider;

import static com.vaadin.flow.component.orderedlayout.FlexComponent.Alignment.CENTER;

public class UserViewHeaderInfo extends VerticalLayout {

    public static final String CLASS_NAME = UserViewHeader.CLASS_NAME + "-info";

    private final EntityViewHeaderInfoTitle<DogHubUser> title;
    private final UserViewHeaderInfoDescription description;

    public UserViewHeaderInfo(UserDataProvider userDataProvider) {
        addClassName(CLASS_NAME);

        setAlignItems(CENTER);

        title = new EntityViewHeaderInfoTitle<>(userDataProvider);
        add(title);

        description = new UserViewHeaderInfoDescription(userDataProvider);
        add(description);
    }

    public void selectedUserChanged(long selectedUserId) {
        title.selectedEntityChanged(selectedUserId);
        description.selectedUserChanged(selectedUserId);
    }
}
