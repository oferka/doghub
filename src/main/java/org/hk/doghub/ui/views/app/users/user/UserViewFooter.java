package org.hk.doghub.ui.views.app.users.user;

import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import lombok.extern.slf4j.Slf4j;
import org.hk.doghub.security.AuthenticatedUser;
import org.hk.doghub.ui.components.shared.EntityNavigationContainer;
import org.hk.doghub.ui.views.app.users.UserDataProvider;
import org.hk.doghub.ui.views.app.users.UsersView;

import static com.vaadin.flow.component.orderedlayout.FlexComponent.JustifyContentMode.CENTER;

@Slf4j
public class UserViewFooter extends HorizontalLayout {

    public static final String CLASS_NAME = UserView.CLASS_NAME + "-footer";

    private final EntityNavigationContainer navigationContainer;

    public UserViewFooter(UserDataProvider userDataProvider, AuthenticatedUser authenticatedUser) {
        addClassName(CLASS_NAME);

        setWidthFull();
        setJustifyContentMode(CENTER);

        navigationContainer = new EntityNavigationContainer(userDataProvider, authenticatedUser, UserView.NAME, UserView.class, UsersView.NAME, UsersView.class);
        add(navigationContainer);
    }

    public long getSelectedUserId() {
        return navigationContainer.getSelectedEntityId();
    }

    public void setSelectedUserId(long selectedUserId) {
        navigationContainer.setSelectedEntityId(selectedUserId);
    }

    public void selectedUserChanged(long selectedUserId) {
        navigationContainer.selectedEntityChanged(selectedUserId);
    }

    public void save() {
        navigationContainer.save();
    }

    public void cancel() {
        navigationContainer.cancel();
    }
}
