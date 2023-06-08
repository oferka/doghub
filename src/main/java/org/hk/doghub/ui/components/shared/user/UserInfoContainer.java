package org.hk.doghub.ui.components.shared.user;

import org.hk.doghub.model.user.DogHubUser;
import org.hk.doghub.ui.components.shared.EntityInfoContainer;
import org.hk.doghub.ui.components.shared.EntityInfoContainerForm;
import org.hk.doghub.ui.views.app.EntityDataProvider;

public class UserInfoContainer extends EntityInfoContainer<DogHubUser, UserUpdateParameters> {

    public static final String CLASS_NAME = "user-info-container";

    public UserInfoContainer(EntityDataProvider<DogHubUser> entityDataProvider, UserUpdateService entityUpdateService) {
        super(entityDataProvider, entityUpdateService);
        addClassName(CLASS_NAME);
    }


    @Override
    protected EntityInfoContainerForm<DogHubUser, UserUpdateParameters> getForm() {
        return new UserInfoContainerForm(entityDataProvider, entityUpdateService);
    }
}
