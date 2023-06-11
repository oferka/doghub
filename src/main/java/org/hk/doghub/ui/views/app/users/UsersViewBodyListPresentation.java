package org.hk.doghub.ui.views.app.users;

import org.hk.doghub.model.user.DogHubUser;
import org.hk.doghub.security.AuthenticatedUser;
import org.hk.doghub.ui.components.shared.EntitiesList;
import org.hk.doghub.ui.components.shared.EntitiesViewBodyListPresentation;
import org.hk.doghub.ui.views.app.EntityDataProvider;

public class UsersViewBodyListPresentation extends EntitiesViewBodyListPresentation<DogHubUser> {

    public static final String CLASS_NAME = UsersViewBody.CLASS_NAME + "-list-presentation";

    public UsersViewBodyListPresentation(UserDataProvider userDataProvider, AuthenticatedUser authenticatedUser) {
        super(userDataProvider, authenticatedUser);
        addClassName(CLASS_NAME);
    }

    @Override
    protected EntitiesList<DogHubUser> getEntitiesList(EntityDataProvider<DogHubUser> entityDataProvider, AuthenticatedUser authenticatedUser) {
        return new UsersList(entityDataProvider, authenticatedUser);
    }
}
