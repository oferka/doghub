package org.hk.doghub.ui.views.app.users.user;

import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import lombok.extern.slf4j.Slf4j;
import org.hk.doghub.ui.components.shared.user.UsersRouterLink;
import org.hk.doghub.ui.views.app.users.UserDataProvider;

import static com.vaadin.flow.component.orderedlayout.FlexComponent.JustifyContentMode.CENTER;

@Slf4j
public class UserViewFooter extends HorizontalLayout {

    public static final String CLASS_NAME = UserView.CLASS_NAME + "-footer";

    private final PreviousUserRouterLink previous;

    private final UsersRouterLink users;

    private final NextUserRouterLink next;

    private long selectedUserId;

    public UserViewFooter(UserDataProvider userDataProvider) {
        addClassName(CLASS_NAME);

        setWidthFull();
        setJustifyContentMode(CENTER);

        previous = new PreviousUserRouterLink(userDataProvider);
        add(previous);

        users = new UsersRouterLink();
        add(users);

        next = new NextUserRouterLink(userDataProvider);
        add(next);
    }

    public long getSelectedUserId() {
        return selectedUserId;
    }

    public void setSelectedUserId(long selectedUserId) {
        this.selectedUserId = selectedUserId;
    }

    public void selectedUserChanged(long selectedUserId) {
        setSelectedUserId(selectedUserId);
        next.selectedUserChanged(selectedUserId);
        previous.selectedUserChanged(selectedUserId);
    }

    public void save() {
        selectedUserChanged(selectedUserId);
    }

    public void cancel() {
        log.info("Cancel");
    }
}
