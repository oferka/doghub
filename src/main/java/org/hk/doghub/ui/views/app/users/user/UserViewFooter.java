package org.hk.doghub.ui.views.app.users.user;

import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.router.RouterLink;
import lombok.extern.slf4j.Slf4j;
import org.hk.doghub.ui.views.app.users.UsersDataProvider;
import org.hk.doghub.ui.views.app.users.UsersView;

import static com.vaadin.flow.component.orderedlayout.FlexComponent.Alignment.CENTER;

@Slf4j
public class UserViewFooter extends HorizontalLayout {

    public static final String CLASS_NAME = UserView.CLASS_NAME + "-footer";

    private final RouterLink users;

    private long selectedUserId;

    public UserViewFooter(UsersDataProvider usersDataProvider) {
        addClassName(CLASS_NAME);

        setWidthFull();
        setAlignItems(CENTER);

        users = new RouterLink(UsersView.NAME, UsersView.class);
        add(users);
    }

    public long getSelectedUserId() {
        return selectedUserId;
    }

    public void setSelectedUserId(long selectedUserId) {
        this.selectedUserId = selectedUserId;
    }

    public void selectedUserChanged(long selectedUserId) {
        setSelectedUserId(selectedUserId);
    }

    public void save() {
        selectedUserChanged(selectedUserId);
    }

    public void cancel() {
        log.info("Cancel");
    }
}
