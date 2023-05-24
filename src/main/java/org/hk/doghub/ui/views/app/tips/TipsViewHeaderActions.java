package org.hk.doghub.ui.views.app.tips;

import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import org.hk.doghub.security.AuthenticatedUser;

public class TipsViewHeaderActions extends HorizontalLayout {

    public static final String CLASS_NAME = TipsViewHeader.CLASS_NAME + "-actions";

    private final TipsViewHeaderActionsPresentationTypeSelector tipsViewHeaderActionsPresentationTypeSelector;
    private final TipsViewHeaderActionsFilterButton tipsViewHeaderActionsFilterButton;
    private final TipsViewHeaderActionsNewRouterLink tipsViewHeaderActionsNewRouterLink;

    public TipsViewHeaderActions(TipsDataProvider tipsDataProvider, TipsViewState tipsViewState, AuthenticatedUser authenticatedUser) {
        addClassName(CLASS_NAME);

        tipsViewHeaderActionsPresentationTypeSelector = new TipsViewHeaderActionsPresentationTypeSelector(tipsDataProvider, tipsViewState, authenticatedUser);
        add(tipsViewHeaderActionsPresentationTypeSelector);

        tipsViewHeaderActionsFilterButton = new TipsViewHeaderActionsFilterButton(tipsDataProvider, tipsViewState, authenticatedUser);
        add(tipsViewHeaderActionsFilterButton);

        tipsViewHeaderActionsNewRouterLink = new TipsViewHeaderActionsNewRouterLink(tipsDataProvider, tipsViewState, authenticatedUser);
        add(tipsViewHeaderActionsNewRouterLink);
    }
}
