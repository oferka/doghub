package org.hk.doghub.ui.views.app.dogs;

import com.vaadin.flow.component.Component;
import org.hk.doghub.model.dog.DogHubDog;
import org.hk.doghub.security.AuthenticatedUser;
import org.hk.doghub.ui.components.shared.EntitiesList;
import org.hk.doghub.ui.components.shared.EntityNameRouterLink;
import org.hk.doghub.ui.views.app.EntityDataProvider;
import org.hk.doghub.ui.views.app.dogs.dog.DogView;
import org.hk.doghub.ui.views.app.users.user.UserView;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class DogsList extends EntitiesList<DogHubDog, DogView> {

    public static final String CLASS_NAME = "dogs-list";

    public DogsList(EntityDataProvider<DogHubDog> entityDataProvider, AuthenticatedUser authenticatedUser) {
        super(entityDataProvider, authenticatedUser, DogView.class);
        addClassName(CLASS_NAME);
    }

    protected List<Component> getListItemInfoBodyComponents(DogHubDog dog, AuthenticatedUser authenticatedUser) {
        List<Component> result = new ArrayList<>();
        if(authenticatedUser.hasAdminRole()) {
            result.add(new EntityNameRouterLink<>(dog.getCreatedBy(), UserView.class));
        }
        return result;
    }

    @Override
    protected Collection<DogHubDog> getItems(EntityDataProvider<DogHubDog> entityDataProvider, AuthenticatedUser authenticatedUser) {
        return ((DogDataProvider)entityDataProvider).findAllForUser(authenticatedUser);
    }
}
