package org.hk.doghub.ui.views.app.tips;

import com.vaadin.flow.router.RouterLink;
import org.hk.doghub.security.AuthenticatedUser;
import org.hk.doghub.ui.views.app.tips.create.TipCreationView;

import static org.apache.commons.lang3.StringUtils.EMPTY;

public class TipsViewHeaderActionsNewRouterLink extends RouterLink {

    public static final String CLASS_NAME = TipsViewHeaderActions.CLASS_NAME + "-new-router-link";

    private final TipsViewHeaderActionsNewButton newButton;

    public TipsViewHeaderActionsNewRouterLink(TipsDataProvider tipsDataProvider, TipsViewState tipsViewState, AuthenticatedUser authenticatedUser) {
        super(EMPTY, TipCreationView.class);
        addClassName(CLASS_NAME);

        newButton = new TipsViewHeaderActionsNewButton(tipsDataProvider, tipsViewState, authenticatedUser);
        add(newButton);
    }
}