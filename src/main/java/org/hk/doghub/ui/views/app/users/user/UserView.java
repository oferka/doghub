package org.hk.doghub.ui.views.app.users.user;

import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.BeforeEvent;
import com.vaadin.flow.router.HasUrlParameter;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;
import jakarta.annotation.security.RolesAllowed;
import org.hk.doghub.ui.views.app.layout.DogHubAppLayout;
import org.hk.doghub.ui.views.app.users.UsersDataProvider;
import org.hk.doghub.ui.views.app.users.UsersView;

@Route(value = UsersView.ROUTE, layout = DogHubAppLayout.class)
@PageTitle(UserView.NAME)
@RolesAllowed({"ADMIN"})
public class UserView extends VerticalLayout implements HasUrlParameter<Long> {

    public static final String ID_PREFIX = "user";
    public static final String ID_SUFFIX = "-view";
    public static final String CLASS_NAME = ID_PREFIX + ID_SUFFIX;
    public static final String NAME = "User";

    private final UserViewHeader userViewHeader;
    private final UserViewBody userViewBody;
    private final UserViewFooter userViewFooter;

    public UserView(UsersDataProvider usersDataProvider) {
        addClassName(CLASS_NAME);

        userViewHeader = new UserViewHeader(usersDataProvider);
        add(userViewHeader);

        userViewBody = new UserViewBody(usersDataProvider);
        addAndExpand(userViewBody);

        userViewFooter = new UserViewFooter(usersDataProvider);
        add(userViewFooter);
    }

    @Override
    public void setParameter(BeforeEvent event, Long parameter) {
        setUser(parameter);
    }

    private void setUser(long selectedUserId) {
        userViewHeader.selectedUserChanged(selectedUserId);
        userViewBody.selectedUserChanged(selectedUserId);
        userViewFooter.selectedUserChanged(selectedUserId);
    }
}
