package org.hk.doghub.ui.views.app.tips;

import com.vaadin.flow.component.Component;
import org.hk.doghub.model.tip.DogHubTip;
import org.hk.doghub.security.AuthenticatedUser;
import org.hk.doghub.ui.components.shared.EntitiesList;
import org.hk.doghub.ui.components.shared.EntityNameRouterLink;
import org.hk.doghub.ui.views.app.EntityDataProvider;
import org.hk.doghub.ui.views.app.tips.tip.TipView;
import org.hk.doghub.ui.views.app.users.user.UserView;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class TipsList extends EntitiesList<DogHubTip, TipView> {

    public static final String CLASS_NAME = "tips-list";

    public TipsList(EntityDataProvider<DogHubTip> entityDataProvider, AuthenticatedUser authenticatedUser) {
        super(entityDataProvider, authenticatedUser, TipView.class);
        addClassName(CLASS_NAME);
    }

    protected List<Component> getListItemInfoBodyComponents(DogHubTip tip, AuthenticatedUser authenticatedUser) {
        List<Component> result = new ArrayList<>();
        if(authenticatedUser.hasAdminRole()) {
            result.add(new EntityNameRouterLink<>(tip.getCreatedBy(), UserView.class));
        }
        return result;
    }

    @Override
    protected Collection<DogHubTip> getItems(EntityDataProvider<DogHubTip> entityDataProvider, AuthenticatedUser authenticatedUser) {
        return ((TipDataProvider)entityDataProvider).findAllForUser(authenticatedUser);
    }
}
