package org.hk.doghub.ui.views.app.tips;

import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import org.hk.doghub.model.DogHubTip;
import org.hk.doghub.security.AuthenticatedUser;
import org.hk.doghub.ui.views.app.users.UserNameRouterLink;

public class TipsListItemInfoSummary extends VerticalLayout {

    public static final String CLASS_NAME = TipsListItemInfo.CLASS_NAME + "-summary";

    private final TipsListItemInfoHeaderCreationTime creationDate;

    private final UserNameRouterLink userNameRouterLink;

    public TipsListItemInfoSummary(DogHubTip tip, AuthenticatedUser authenticatedUser) {
        addClassName(CLASS_NAME);
        creationDate = new TipsListItemInfoHeaderCreationTime(tip, authenticatedUser);
        add(creationDate);

        userNameRouterLink = new UserNameRouterLink(tip.getCreatedBy());
        if(authenticatedUser.hasAdminRole()) {
            add(userNameRouterLink);
        }
    }
}
