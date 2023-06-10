package org.hk.doghub.ui.views.app.tips;

import com.vaadin.flow.component.html.Div;
import org.hk.doghub.model.tip.DogHubTip;
import org.hk.doghub.ui.components.shared.EntityRouterLink;
import org.hk.doghub.ui.views.app.tips.tip.TipView;

public class TipsListItemInfoHeaderName extends Div {

    public static final String CLASS_NAME = TipsListItemInfoHeader.CLASS_NAME + "-name";

    private final EntityRouterLink<DogHubTip> link;

    public TipsListItemInfoHeaderName(DogHubTip tip) {
        addClassName(CLASS_NAME);
        link = new EntityRouterLink<>(tip, TipView.class);
        add(link);
    }
}
