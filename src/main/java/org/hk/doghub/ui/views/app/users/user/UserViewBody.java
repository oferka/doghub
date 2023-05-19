package org.hk.doghub.ui.views.app.users.user;

import com.vaadin.flow.component.html.Label;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.RouterLink;
import org.hk.doghub.ui.views.app.users.UsersDataProvider;
import org.hk.doghub.ui.views.app.users.UsersView;

import static com.vaadin.flow.component.orderedlayout.FlexComponent.Alignment.CENTER;

public class UserViewBody extends VerticalLayout {

    public static final String CLASS_NAME = UserView.CLASS_NAME + "-body";

    private final Label selectedIdLabel;
    private final RouterLink usersRouterLink;

    public UserViewBody(UsersDataProvider usersDataProvider) {
        addClassName(CLASS_NAME);

        setWidthFull();
        setAlignItems(CENTER);

        selectedIdLabel = new Label();
        add(selectedIdLabel);

        usersRouterLink = new RouterLink(UsersView.NAME, UsersView.class);
        add(usersRouterLink);
    }

    public void selectedUserChanged(long selectedUserId) {
        selectedIdLabel.setText("Selected User: " + selectedUserId);
    }
}
