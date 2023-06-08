package org.hk.doghub.ui.views.app.users.user;

import org.hk.doghub.model.user.DogHubUser;
import org.hk.doghub.ui.components.shared.EntityInfoContainer;
import org.hk.doghub.ui.components.shared.EntityUpdateService;
import org.hk.doghub.ui.components.shared.EntityViewBody;
import org.hk.doghub.ui.components.shared.user.UserInfoContainer;
import org.hk.doghub.ui.components.shared.user.UserUpdateParameters;
import org.hk.doghub.ui.views.app.EntityDataProvider;

public class UserViewBody extends EntityViewBody<DogHubUser, UserUpdateParameters> {

    public static final String CLASS_NAME = UserView.CLASS_NAME + "-body";

    public UserViewBody(EntityDataProvider<DogHubUser> entityDataProvider, EntityUpdateService<DogHubUser, UserUpdateParameters> entityUpdateService) {
        super(entityDataProvider, entityUpdateService);
        addClassName(CLASS_NAME);
    }

    @Override
    protected EntityInfoContainer<DogHubUser, UserUpdateParameters> getEntityInfo() {
        return new UserInfoContainer(entityDataProvider, entityUpdateService);
    }
}
