package org.hk.doghub.ui.views.app.users;

import com.vaadin.flow.component.Component;
import org.hk.doghub.model.user.DogHubUser;
import org.hk.doghub.security.AuthenticatedUser;
import org.hk.doghub.ui.components.shared.DogHubLabel;
import org.hk.doghub.ui.components.shared.EntitiesList;
import org.hk.doghub.ui.views.app.EntityDataProvider;
import org.hk.doghub.ui.views.app.users.user.UserView;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class UsersList extends EntitiesList<DogHubUser, UserView> {

    public static final String CLASS_NAME = "users-list";

    public UsersList(EntityDataProvider<DogHubUser> entityDataProvider, AuthenticatedUser authenticatedUser) {
        super(entityDataProvider, authenticatedUser, UserView.class);
    }

    protected List<Component> getListItemInfoBodyComponents(DogHubUser user, AuthenticatedUser authenticatedUser) {
        List<Component> result = new ArrayList<>();
        result.add(new DogHubLabel(user.getCompany()));
        return result;
    }

    @Override
    protected Collection<DogHubUser> getItems(EntityDataProvider<DogHubUser> entityDataProvider, AuthenticatedUser authenticatedUser) {
        return entityDataProvider.findAll();
    }
}
