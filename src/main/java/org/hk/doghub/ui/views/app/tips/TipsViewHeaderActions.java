package org.hk.doghub.ui.views.app.tips;

import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import org.hk.doghub.ui.components.shared.EntitiesViewHeaderActionsFilterButton;
import org.hk.doghub.ui.components.shared.EntitiesViewHeaderActionsNewRouterLink;
import org.hk.doghub.ui.components.shared.EntitiesViewHeaderActionsPresentationTypeSelector;
import org.hk.doghub.ui.views.app.tips.create.TipCreationView;
import org.hk.doghub.ui.views.app.tips.tip.TipView;

public class TipsViewHeaderActions extends HorizontalLayout {

    public static final String CLASS_NAME = TipsViewHeader.CLASS_NAME + "-actions";

    private final EntitiesViewHeaderActionsPresentationTypeSelector presentationTypeSelector;
    private final EntitiesViewHeaderActionsFilterButton filter;
    private final EntitiesViewHeaderActionsNewRouterLink newRouterLink;

    public TipsViewHeaderActions(TipsViewState tipsViewState) {
        addClassName(CLASS_NAME);

        presentationTypeSelector = new EntitiesViewHeaderActionsPresentationTypeSelector(tipsViewState);
        add(presentationTypeSelector);

        filter = new EntitiesViewHeaderActionsFilterButton();
        add(filter);

        newRouterLink = new EntitiesViewHeaderActionsNewRouterLink(TipCreationView.class, TipView.NAME);
        add(newRouterLink);
    }
}
