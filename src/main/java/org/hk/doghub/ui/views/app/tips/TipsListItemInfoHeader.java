package org.hk.doghub.ui.views.app.tips;

import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import org.hk.doghub.model.tip.DogHubTip;
import org.hk.doghub.security.AuthenticatedUser;

public class TipsListItemInfoHeader extends HorizontalLayout {

    public static final String CLASS_NAME = TipsListItemInfo.CLASS_NAME + "-header";

    private final TipsListItemInfoHeaderName name;

    private final TipAnchor anchor;

    public TipsListItemInfoHeader(DogHubTip tip, AuthenticatedUser authenticatedUser) {
        addClassName(CLASS_NAME);
        setSpacing(false);
        getThemeList().add("spacing-s");

        name = new TipsListItemInfoHeaderName(tip, authenticatedUser);
        add(name);

        anchor = new TipAnchor(tip, authenticatedUser);
        add(anchor);
    }
}
