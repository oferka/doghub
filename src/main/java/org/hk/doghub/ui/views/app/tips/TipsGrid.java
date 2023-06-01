package org.hk.doghub.ui.views.app.tips;

import com.vaadin.flow.component.grid.Grid;
import com.vaadin.flow.data.renderer.ComponentRenderer;
import org.hk.doghub.model.tip.DogHubTip;
import org.hk.doghub.security.AuthenticatedUser;
import org.hk.doghub.ui.components.shared.tip.TipAvatar;
import org.hk.doghub.ui.components.shared.user.UserAvatarRouterLink;

public class TipsGrid extends Grid<DogHubTip> {

    public static final String CLASS_NAME = "tips-grid";

    public TipsGrid(TipsDataProvider tipsDataProvider, AuthenticatedUser authenticatedUser) {
        addClassName(CLASS_NAME);
        setWidthFull();
        addColumns(authenticatedUser);
        setItems(tipsDataProvider.findAllForUser(authenticatedUser));
    }

    private void addColumns(AuthenticatedUser authenticatedUser) {
        addColumn(new ComponentRenderer<>(tip -> new TipIdRouterLink(tip, authenticatedUser))).setHeader("ID").setComparator(DogHubTip::getId);
        addColumn(new ComponentRenderer<>(TipAvatar::new)).setHeader("Favicon").setComparator(DogHubTip::getMoreInfo);
        addColumn(new ComponentRenderer<>(tip -> new TipNameRouterLink(tip, authenticatedUser))).setHeader("Name").setComparator(DogHubTip::getName);
        addColumn(new ComponentRenderer<>(tip -> new TipAnchor(tip, authenticatedUser))).setHeader("More Info").setComparator(DogHubTip::getMoreInfo);
        if(authenticatedUser.hasAdminRole()) {
            addColumn(new ComponentRenderer<>(tip -> new UserAvatarRouterLink(tip.getCreatedBy()))).setHeader("Created By").setComparator(tip -> tip.getCreatedBy().getName());
        }
        addColumn(new ComponentRenderer<>(tip -> new TipCreationTime(tip, authenticatedUser))).setHeader("Creation Time").setComparator(DogHubTip::getCreationTime);
        addColumn(new ComponentRenderer<>(tip -> new TipLikes(tip, authenticatedUser))).setHeader("Likes").setComparator(DogHubTip::getLikes);
        addColumn(new ComponentRenderer<>(tip -> new TipComments(tip, authenticatedUser))).setHeader("Comments").setComparator(DogHubTip::getComments);
        addColumn(new ComponentRenderer<>(tip -> new TipShares(tip, authenticatedUser))).setHeader("Shares").setComparator(DogHubTip::getShares);
    }
}
