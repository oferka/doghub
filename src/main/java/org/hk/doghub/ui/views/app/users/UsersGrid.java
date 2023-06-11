package org.hk.doghub.ui.views.app.users;

import com.vaadin.flow.data.renderer.ComponentRenderer;
import org.hk.doghub.model.user.DogHubUser;
import org.hk.doghub.security.AuthenticatedUser;
import org.hk.doghub.ui.components.shared.EntitiesGrid;
import org.hk.doghub.ui.views.app.EntityDataProvider;
import org.hk.doghub.ui.views.app.users.user.UserView;

import java.util.Collection;

public class UsersGrid extends EntitiesGrid<DogHubUser, UserView> {

    public static final String CLASS_NAME = "users-grid";

    public UsersGrid(EntityDataProvider<DogHubUser> entityDataProvider, AuthenticatedUser authenticatedUser) {
        super(entityDataProvider, authenticatedUser, UserView.class);
        addClassName(CLASS_NAME);
    }

    @Override
    protected void addSpecificColumns(AuthenticatedUser authenticatedUser, Class<? extends UserView> entityClass) {
        addColumn(new ComponentRenderer<>(UserTipsRouterLink::new)).setHeader("Tips").setComparator(user -> user.getDogHubTips().size());
    }

    @Override
    protected Collection<DogHubUser> getItems(EntityDataProvider<DogHubUser> entityDataProvider, AuthenticatedUser authenticatedUser) {
        return entityDataProvider.findAll();
    }
}
