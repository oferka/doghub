package org.hk.doghub.ui.views.app.tips;

import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import org.hk.doghub.model.tip.DogHubTip;
import org.hk.doghub.security.AuthenticatedUser;

public class TipsListItemInfo extends VerticalLayout {

    public static final String CLASS_NAME = TipsListItem.CLASS_NAME + "-info";

    private final TipsListItemInfoHeader header;
    private final TipsListItemInfoSummary summary;
    private final TipsListItemInfoActions actions;

    public TipsListItemInfo(DogHubTip tip, AuthenticatedUser authenticatedUser) {
        addClassName(CLASS_NAME);
        setSpacing(false);
        setPadding(false);

        header = new TipsListItemInfoHeader(tip);
        add(header);

        summary = new TipsListItemInfoSummary(tip, authenticatedUser);
        add(summary);

        actions = new TipsListItemInfoActions(tip, authenticatedUser);
        add(actions);
    }
}
