package org.hk.doghub.ui.views.app.users.user;

import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import lombok.extern.slf4j.Slf4j;
import org.hk.doghub.ui.components.shared.UsersRouterLink;
import org.hk.doghub.ui.views.app.users.UsersDataProvider;

import static com.vaadin.flow.component.orderedlayout.FlexComponent.JustifyContentMode.CENTER;

@Slf4j
public class UserViewFooter extends HorizontalLayout {

    public static final String CLASS_NAME = UserView.CLASS_NAME + "-footer";

    private final PreviousUserRouterLink previousUser;

    private final UsersRouterLink users;

    private final NextUserRouterLink nextUser;

    private long selectedUserId;

    public UserViewFooter(UsersDataProvider usersDataProvider) {
        addClassName(CLASS_NAME);

        setWidthFull();
        setJustifyContentMode(CENTER);

        previousUser = new PreviousUserRouterLink(usersDataProvider);
        add(previousUser);

        users = new UsersRouterLink();
        add(users);

        nextUser = new NextUserRouterLink(usersDataProvider);
        add(nextUser);
    }

    public long getSelectedUserId() {
        return selectedUserId;
    }

    public void setSelectedUserId(long selectedUserId) {
        this.selectedUserId = selectedUserId;
    }

    public void selectedUserChanged(long selectedUserId) {
        setSelectedUserId(selectedUserId);
        nextUser.selectedUserChanged(selectedUserId);
        previousUser.selectedUserChanged(selectedUserId);
    }

    public void save() {
        selectedUserChanged(selectedUserId);
    }

    public void cancel() {
        log.info("Cancel");
    }
}
