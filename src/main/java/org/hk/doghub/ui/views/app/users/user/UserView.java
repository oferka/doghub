package org.hk.doghub.ui.views.app.users.user;

import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;
import jakarta.annotation.security.RolesAllowed;
import org.hk.doghub.model.user.DogHubUser;
import org.hk.doghub.security.AuthenticatedUser;
import org.hk.doghub.ui.components.shared.EntityUpdateService;
import org.hk.doghub.ui.components.shared.EntityView;
import org.hk.doghub.ui.components.shared.EntityViewBody;
import org.hk.doghub.ui.components.shared.user.UserUpdateParameters;
import org.hk.doghub.ui.views.app.EntityDataProvider;
import org.hk.doghub.ui.views.app.layout.DogHubAppLayout;
import org.hk.doghub.ui.views.app.users.UsersView;

@Route(value = UsersView.ROUTE, layout = DogHubAppLayout.class)
@PageTitle(UserView.NAME)
@RolesAllowed({"ADMIN"})
public class UserView extends EntityView<DogHubUser, UserUpdateParameters> {

    private static final String ID_PREFIX = "user";
    private static final String ID_SUFFIX = "-view";
    public static final String CLASS_NAME = ID_PREFIX + ID_SUFFIX;
    public static final String NAME = "User";

    public UserView(EntityDataProvider<DogHubUser> entityDataProvider, AuthenticatedUser authenticatedUser, EntityUpdateService<DogHubUser, UserUpdateParameters> entityUpdateService) {
        super(entityDataProvider, authenticatedUser, entityUpdateService);
        addClassName(CLASS_NAME);
    }

    protected EntityViewBody<DogHubUser, UserUpdateParameters> getBody() {
        return new UserViewBody(entityDataProvider, entityUpdateService);
    }

    @Override
    protected String getEntityLabel() {
        return UserView.NAME;
    }

    @Override
    protected Class getEntityClass() {
        return UserView.class;
    }

    @Override
    protected String getEntitiesLabel() {
        return UsersView.NAME;
    }

    @Override
    protected Class getEntitiesClass() {
        return UsersView.class;
    }
}
