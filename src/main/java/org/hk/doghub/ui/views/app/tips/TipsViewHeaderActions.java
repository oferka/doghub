package org.hk.doghub.ui.views.app.tips;

import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import org.hk.doghub.security.AuthenticatedUser;
import org.hk.doghub.ui.components.shared.EntitiesViewHeaderActionsPresentationTypeSelector;

public class TipsViewHeaderActions extends HorizontalLayout {

    public static final String CLASS_NAME = TipsViewHeader.CLASS_NAME + "-actions";

    private final EntitiesViewHeaderActionsPresentationTypeSelector presentationTypeSelector;
    private final TipsViewHeaderActionsFilterButton filter;
    private final TipsViewHeaderActionsNewRouterLink newRouterLink;

    public TipsViewHeaderActions(TipDataProvider tipDataProvider, TipsViewState tipsViewState, AuthenticatedUser authenticatedUser) {
        addClassName(CLASS_NAME);

        presentationTypeSelector = new EntitiesViewHeaderActionsPresentationTypeSelector(tipsViewState);
        add(presentationTypeSelector);

        filter = new TipsViewHeaderActionsFilterButton(tipDataProvider, tipsViewState, authenticatedUser);
        add(filter);

        newRouterLink = new TipsViewHeaderActionsNewRouterLink(tipDataProvider, tipsViewState, authenticatedUser);
        add(newRouterLink);
    }
}
