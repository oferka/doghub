package org.hk.doghub.ui.views.app.tips;

import com.vaadin.flow.component.grid.Grid;
import com.vaadin.flow.data.renderer.ComponentRenderer;
import org.hk.doghub.model.tip.DogHubTip;
import org.hk.doghub.security.AuthenticatedUser;
import org.hk.doghub.ui.components.shared.*;
import org.hk.doghub.ui.components.shared.user.UserAvatarRouterLink;

public class TipsGrid extends Grid<DogHubTip> {

    public static final String CLASS_NAME = "tips-grid";

    public TipsGrid(TipDataProvider tipDataProvider, AuthenticatedUser authenticatedUser) {
        addClassName(CLASS_NAME);
        setWidthFull();
        addColumns(authenticatedUser);
        setItems(tipDataProvider.findAllForUser(authenticatedUser));
    }

    private void addColumns(AuthenticatedUser authenticatedUser) {
        addColumn(new ComponentRenderer<>(TipIdRouterLink::new)).setHeader("ID").setComparator(DogHubTip::getId);
        addColumn(new ComponentRenderer<>(EntityAvatar<DogHubTip>::new)).setHeader("Favicon").setComparator(DogHubTip::getMoreInfo);
        addColumn(new ComponentRenderer<>(TipNameRouterLink::new)).setHeader("Name").setComparator(DogHubTip::getName);
        addColumn(new ComponentRenderer<>(TipAnchor::new)).setHeader("More Info").setComparator(DogHubTip::getMoreInfo);
        if(authenticatedUser.hasAdminRole()) {
            addColumn(new ComponentRenderer<>(tip -> new UserAvatarRouterLink(tip.getCreatedBy()))).setHeader("Created By").setComparator(tip -> tip.getCreatedBy().getName());
        }
        addColumn(new ComponentRenderer<>(tip -> new CreationTimeLabel(tip.getCreationTime()))).setHeader("Creation Time").setComparator(DogHubTip::getCreationTime);
        addColumn(new ComponentRenderer<>(tip -> new LikesContainer(tip.getFeedback().getLikes()))).setHeader("Likes").setComparator(tip -> tip.getFeedback().getLikes());
        addColumn(new ComponentRenderer<>(tip -> new CommentsContainer(tip.getFeedback().getComments()))).setHeader("Comments").setComparator(tip -> tip.getFeedback().getComments());
        addColumn(new ComponentRenderer<>(tip -> new SharesContainer(tip.getFeedback().getShares()))).setHeader("Shares").setComparator(tip -> tip.getFeedback().getShares());
    }
}
