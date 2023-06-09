package org.hk.doghub.ui.views.app.tips;

import com.vaadin.flow.router.RouterLink;
import org.hk.doghub.security.AuthenticatedUser;
import org.hk.doghub.ui.components.shared.EntitiesViewHeaderActionsNewButton;
import org.hk.doghub.ui.views.app.tips.create.TipCreationView;
import org.hk.doghub.ui.views.app.tips.tip.TipView;

import static org.apache.commons.lang3.StringUtils.EMPTY;

public class TipsViewHeaderActionsNewRouterLink extends RouterLink {

    public static final String CLASS_NAME = TipsViewHeaderActions.CLASS_NAME + "-new-router-link";

    private final EntitiesViewHeaderActionsNewButton newButton;

    public TipsViewHeaderActionsNewRouterLink(TipDataProvider tipDataProvider, TipsViewState tipsViewState, AuthenticatedUser authenticatedUser) {
        super(EMPTY, TipCreationView.class);
        addClassName(CLASS_NAME);

        newButton = new EntitiesViewHeaderActionsNewButton(TipView.NAME);
        add(newButton);
    }
}
