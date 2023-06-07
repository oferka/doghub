package org.hk.doghub.ui.views.app.users.user;

import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import lombok.extern.slf4j.Slf4j;
import org.hk.doghub.security.AuthenticatedUser;
import org.hk.doghub.ui.components.shared.EntitiesRouterLink;
import org.hk.doghub.ui.components.shared.NextEntityRouterLink;
import org.hk.doghub.ui.components.shared.PreviousEntityRouterLink;
import org.hk.doghub.ui.views.app.users.UserDataProvider;
import org.hk.doghub.ui.views.app.users.UsersView;

import static com.vaadin.flow.component.orderedlayout.FlexComponent.JustifyContentMode.CENTER;

@Slf4j
public class UserViewFooter extends HorizontalLayout {

    public static final String CLASS_NAME = UserView.CLASS_NAME + "-footer";

    private final PreviousEntityRouterLink previous;

    private final EntitiesRouterLink entities;

    private final NextEntityRouterLink next;

    private long selectedUserId;

    public UserViewFooter(UserDataProvider userDataProvider, AuthenticatedUser authenticatedUser) {
        addClassName(CLASS_NAME);

        setWidthFull();
        setJustifyContentMode(CENTER);

        previous = new PreviousEntityRouterLink(userDataProvider, authenticatedUser, UserView.NAME, UserView.class);
        add(previous);

        entities = new EntitiesRouterLink(UsersView.class, UsersView.NAME);
        add(entities);

        next = new NextEntityRouterLink(userDataProvider, authenticatedUser, UserView.NAME, UserView.class);
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
        next.selectedEntityChanged(selectedUserId);
        previous.selectedEntityChanged(selectedUserId);
    }

    public void save() {
        selectedUserChanged(selectedUserId);
    }

    public void cancel() {
        log.info("Cancel");
    }
}
