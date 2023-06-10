package org.hk.doghub.ui.views.app.tips;

import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import org.hk.doghub.model.tip.DogHubTip;
import org.hk.doghub.security.AuthenticatedUser;
import org.hk.doghub.ui.views.app.users.UserNameRouterLink;

public class TipsListItemInfoSummary extends VerticalLayout {

    public static final String CLASS_NAME = TipsListItemInfo.CLASS_NAME + "-summary";

    private final TipsListItemInfoCreationTime creationDate;

    private final UserNameRouterLink userName;

    public TipsListItemInfoSummary(DogHubTip tip, AuthenticatedUser authenticatedUser) {
        addClassName(CLASS_NAME);
        creationDate = new TipsListItemInfoCreationTime(tip, authenticatedUser);
        add(creationDate);

        userName = new UserNameRouterLink(tip.getCreatedBy());
        if(authenticatedUser.hasAdminRole()) {
            add(userName);
        }
    }
}
