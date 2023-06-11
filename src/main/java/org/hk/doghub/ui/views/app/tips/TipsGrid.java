package org.hk.doghub.ui.views.app.tips;

import com.vaadin.flow.data.renderer.ComponentRenderer;
import org.hk.doghub.model.tip.DogHubTip;
import org.hk.doghub.security.AuthenticatedUser;
import org.hk.doghub.ui.components.shared.EntitiesGrid;
import org.hk.doghub.ui.components.shared.user.UserAvatarRouterLink;
import org.hk.doghub.ui.views.app.EntityDataProvider;
import org.hk.doghub.ui.views.app.tips.tip.TipView;

public class TipsGrid extends EntitiesGrid<DogHubTip, TipView> {

    public static final String CLASS_NAME = "tips-grid";

    public TipsGrid(EntityDataProvider<DogHubTip> entityDataProvider, AuthenticatedUser authenticatedUser) {
        super(entityDataProvider, authenticatedUser, TipView.class);
        addClassName(CLASS_NAME);
    }

    @Override
    protected void addSpecificColumns(AuthenticatedUser authenticatedUser, Class<? extends TipView> entityClass) {
        addColumn(new ComponentRenderer<>(TipAnchor::new)).setHeader("More Info").setComparator(DogHubTip::getMoreInfo);
        if(authenticatedUser.hasAdminRole()) {
            addColumn(new ComponentRenderer<>(tip -> new UserAvatarRouterLink(tip.getCreatedBy()))).setHeader("Created By").setComparator(tip -> tip.getCreatedBy().getName());
        }
    }
}
