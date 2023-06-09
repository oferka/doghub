package org.hk.doghub.ui.views.app.tips;

import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import org.hk.doghub.security.AuthenticatedUser;

public class TipsViewHeaderActions extends HorizontalLayout {

    public static final String CLASS_NAME = TipsViewHeader.CLASS_NAME + "-actions";

    private final TipsViewHeaderActionsPresentationTypeSelector presentationTypeSelector;
    private final TipsViewHeaderActionsFilterButton filter;
    private final TipsViewHeaderActionsNewRouterLink newRouterLink;

    public TipsViewHeaderActions(TipDataProvider tipDataProvider, TipsViewState tipsViewState, AuthenticatedUser authenticatedUser) {
        addClassName(CLASS_NAME);

        presentationTypeSelector = new TipsViewHeaderActionsPresentationTypeSelector(tipsViewState);
        add(presentationTypeSelector);

        filter = new TipsViewHeaderActionsFilterButton(tipDataProvider, tipsViewState, authenticatedUser);
        add(filter);

        newRouterLink = new TipsViewHeaderActionsNewRouterLink(tipDataProvider, tipsViewState, authenticatedUser);
        add(newRouterLink);
    }
}
