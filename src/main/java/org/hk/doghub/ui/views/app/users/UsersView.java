package org.hk.doghub.ui.views.app.users;

import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;
import jakarta.annotation.security.RolesAllowed;
import org.hk.doghub.model.user.DogHubUser;
import org.hk.doghub.security.AuthenticatedUser;
import org.hk.doghub.ui.components.shared.EntitiesViewBody;
import org.hk.doghub.ui.components.shared.EntitiesViewFooter;
import org.hk.doghub.ui.components.shared.EntitiesViewHeader;
import org.hk.doghub.ui.views.app.admin.AdminView;
import org.hk.doghub.ui.views.app.layout.DogHubAppLayout;
import org.hk.doghub.ui.views.app.users.create.UserCreationView;
import org.hk.doghub.ui.views.app.users.user.UserView;

import static com.vaadin.flow.component.icon.VaadinIcon.USERS;

@PageTitle(UsersView.NAME)
@Route(value = UsersView.ROUTE, layout = DogHubAppLayout.class)
@RolesAllowed({"ADMIN"})
public class UsersView extends VerticalLayout {

    public static final String ROUTE = AdminView.ROUTE + "/users";
    private static final String ID_PREFIX = "users";
    private static final String ID_SUFFIX = "-view";
    public static final String CLASS_NAME = ID_PREFIX + ID_SUFFIX;
    public static final String NAME = "Users";
    private final EntitiesViewHeader header;
    private final EntitiesViewBody<DogHubUser, UserView> body;
    private final EntitiesViewFooter footer;

    public UsersView(UserDataProvider userDataProvider, UsersViewState usersViewState, AuthenticatedUser authenticatedUser) {
        addClassName(CLASS_NAME);

        header = new EntitiesViewHeader(usersViewState, USERS, UsersView.NAME, userDataProvider.count(), "Users view description", UserCreationView.class, UserView.NAME);
        add(header);

        body = new EntitiesViewBody<>(new UsersList(userDataProvider, authenticatedUser), new UsersGrid(userDataProvider, authenticatedUser), usersViewState);
        addAndExpand(body);

        footer = new EntitiesViewFooter();
        add(footer);
    }
}
