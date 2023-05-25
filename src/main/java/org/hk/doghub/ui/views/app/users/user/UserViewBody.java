package org.hk.doghub.ui.views.app.users.user;

import com.vaadin.flow.component.html.Label;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.RouterLink;
import org.hk.doghub.ui.views.app.users.UsersDataProvider;
import org.hk.doghub.ui.views.app.users.UsersView;

import static com.vaadin.flow.component.orderedlayout.FlexComponent.Alignment.CENTER;

public class UserViewBody extends VerticalLayout {

    public static final String CLASS_NAME = UserView.CLASS_NAME + "-body";

    private final Label selectedId;
    private final RouterLink users;

    public UserViewBody(UsersDataProvider usersDataProvider) {
        addClassName(CLASS_NAME);

        setWidthFull();
        setAlignItems(CENTER);

        selectedId = new Label();
        add(selectedId);

        users = new RouterLink(UsersView.NAME, UsersView.class);
        add(users);
    }

    public void selectedUserChanged(long selectedUserId) {
        selectedId.setText("Selected User: " + selectedUserId);
    }
}
