package org.hk.doghub.ui.views.app.tips;

import org.hk.doghub.model.tip.DogHubTip;
import org.hk.doghub.security.AuthenticatedUser;
import org.hk.doghub.ui.components.shared.EntitiesList;
import org.hk.doghub.ui.components.shared.EntitiesViewBodyListPresentation;
import org.hk.doghub.ui.views.app.EntityDataProvider;

public class TipsViewBodyListPresentation extends EntitiesViewBodyListPresentation<DogHubTip> {

    public static final String CLASS_NAME = TipsViewBody.CLASS_NAME + "-list-presentation";

    public TipsViewBodyListPresentation(EntityDataProvider<DogHubTip> entityDataProvider, AuthenticatedUser authenticatedUser) {
        super(entityDataProvider, authenticatedUser);
        addClassName(CLASS_NAME);
    }

    @Override
    protected EntitiesList<DogHubTip> getEntitiesList(EntityDataProvider<DogHubTip> entityDataProvider, AuthenticatedUser authenticatedUser) {
        return new TipsList(entityDataProvider, authenticatedUser);
    }
}
