package org.hk.doghub.ui.views.app.tips;

import com.vaadin.flow.component.html.Div;
import org.hk.doghub.model.tip.DogHubTip;

public class TipsListItemInfoHeaderName extends Div {

    public static final String CLASS_NAME = TipsListItemInfoHeader.CLASS_NAME + "-name";

    private final TipRouterLink link;

    public TipsListItemInfoHeaderName(DogHubTip tip) {
        addClassName(CLASS_NAME);
        link = new TipRouterLink(tip);
        add(link);
    }
}
