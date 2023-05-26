package org.hk.doghub.ui.views.app.users.user;

import com.vaadin.flow.component.html.H2;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.router.RouterLink;
import org.hk.doghub.ui.views.app.users.UsersDataProvider;
import org.hk.doghub.ui.views.app.users.UsersView;

import static com.vaadin.flow.component.orderedlayout.FlexComponent.Alignment.CENTER;

public class UserViewFooter extends HorizontalLayout {

    public static final String CLASS_NAME = UserView.CLASS_NAME + "-footer";

    private final H2 label;

    private final RouterLink users;

    public UserViewFooter(UsersDataProvider usersDataProvider) {
        addClassName(CLASS_NAME);

        setWidthFull();
        setAlignItems(CENTER);

        label = new H2("say what again");
        add(label);

        users = new RouterLink(UsersView.NAME, UsersView.class);
        add(users);
    }

    public void selectedUserChanged(long selectedUserId) {
        label.setText("Selected User: " + selectedUserId);
    }
}
