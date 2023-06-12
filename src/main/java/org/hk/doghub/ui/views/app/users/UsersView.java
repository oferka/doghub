package org.hk.doghub.ui.views.app.users;

import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;
import jakarta.annotation.security.RolesAllowed;
import jakarta.validation.constraints.NotNull;
import org.hk.doghub.model.user.DogHubUser;
import org.hk.doghub.security.AuthenticatedUser;
import org.hk.doghub.ui.components.shared.EntitiesView;
import org.hk.doghub.ui.components.shared.EntitiesViewBody;
import org.hk.doghub.ui.components.shared.EntitiesViewHeader;
import org.hk.doghub.ui.components.shared.EntitiesViewState;
import org.hk.doghub.ui.views.app.EntityDataProvider;
import org.hk.doghub.ui.views.app.admin.AdminView;
import org.hk.doghub.ui.views.app.layout.DogHubAppLayout;
import org.hk.doghub.ui.views.app.users.create.UserCreationView;
import org.hk.doghub.ui.views.app.users.user.UserView;

import static com.vaadin.flow.component.icon.VaadinIcon.USERS;

@PageTitle(UsersView.NAME)
@Route(value = UsersView.ROUTE, layout = DogHubAppLayout.class)
@RolesAllowed({"ADMIN"})
public class UsersView extends EntitiesView<DogHubUser, UserView> {

    public static final String ROUTE = AdminView.ROUTE + "/users";
    private static final String ID_PREFIX = "users";
    private static final String ID_SUFFIX = "-view";
    public static final String CLASS_NAME = ID_PREFIX + ID_SUFFIX;
    public static final String NAME = "Users";

    public UsersView(EntityDataProvider<DogHubUser> entityDataProvider, UsersViewState viewState, AuthenticatedUser authenticatedUser) {
        super(entityDataProvider, viewState, authenticatedUser);
        addClassName(CLASS_NAME);
    }

    @Override
    protected @NotNull EntitiesViewHeader getViewHeader(EntityDataProvider<DogHubUser> entityDataProvider, EntitiesViewState viewState, AuthenticatedUser authenticatedUser) {
        return new EntitiesViewHeader(viewState, USERS, UsersView.NAME, entityDataProvider.count(), "Users view description", UserCreationView.class, UserView.NAME);
    }

    @Override
    protected @NotNull EntitiesViewBody<DogHubUser, UserView> getViewBody(EntityDataProvider<DogHubUser> entityDataProvider, EntitiesViewState viewState, AuthenticatedUser authenticatedUser) {
        return new EntitiesViewBody<>(new UsersList(entityDataProvider, authenticatedUser), new UsersGrid(entityDataProvider, authenticatedUser), viewState);
    }
}
