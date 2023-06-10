package org.hk.doghub.ui.views.app.tips;

import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import org.hk.doghub.model.tip.DogHubTip;
import org.hk.doghub.model.user.DogHubUser;
import org.hk.doghub.security.AuthenticatedUser;
import org.hk.doghub.ui.components.shared.EntitiesListItemInfoCreationTime;
import org.hk.doghub.ui.components.shared.EntityRouterLink;
import org.hk.doghub.ui.views.app.users.user.UserView;

public class TipsListItemInfoSummary extends VerticalLayout {

    public static final String CLASS_NAME = TipsListItemInfo.CLASS_NAME + "-summary";

    private final EntitiesListItemInfoCreationTime<DogHubTip> creationDate;

    private final EntityRouterLink<DogHubUser> createdBy;

    public TipsListItemInfoSummary(DogHubTip tip, AuthenticatedUser authenticatedUser) {
        addClassName(CLASS_NAME);
        creationDate = new EntitiesListItemInfoCreationTime<>(tip);
        add(creationDate);

        createdBy = new EntityRouterLink<>(tip.getCreatedBy(), UserView.class);
        if(authenticatedUser.hasAdminRole()) {
            add(createdBy);
        }
    }
}
