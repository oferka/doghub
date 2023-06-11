package org.hk.doghub.ui.views.app.users;

import com.vaadin.flow.component.Component;
import org.hk.doghub.model.user.DogHubUser;
import org.hk.doghub.security.AuthenticatedUser;
import org.hk.doghub.ui.components.shared.DogHubLabel;
import org.hk.doghub.ui.components.shared.EntitiesList;

import java.util.ArrayList;
import java.util.List;

public class UsersList extends EntitiesList<DogHubUser> {

    public static final String CLASS_NAME = "users-list";

    public UsersList(UserDataProvider userDataProvider, AuthenticatedUser authenticatedUser) {
        super(userDataProvider, authenticatedUser);
    }

    protected List<Component> getListItemInfoBodyComponents(DogHubUser user, AuthenticatedUser authenticatedUser) {
        List<Component> result = new ArrayList<>();
        result.add(new DogHubLabel(user.getCompany()));
        return result;
    }
}
