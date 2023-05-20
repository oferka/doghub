package org.hk.doghub.ui.views.app.tips;

import com.vaadin.flow.component.html.Div;
import org.hk.doghub.model.tip.DogHubTip;
import org.hk.doghub.security.AuthenticatedUser;

public class TipsListItemInfoHeaderName extends Div {

    public static final String CLASS_NAME = TipsListItemInfoHeader.CLASS_NAME + "-name";

    private final TipRouterLink link;

    public TipsListItemInfoHeaderName(DogHubTip tip, AuthenticatedUser authenticatedUser) {
        addClassName(CLASS_NAME);
        link = new TipRouterLink(tip, authenticatedUser);
        add(link);
    }
}
