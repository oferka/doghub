package org.hk.doghub.ui.views.app.tips;

import com.vaadin.flow.router.RouterLink;
import org.hk.doghub.model.tip.DogHubTip;
import org.hk.doghub.ui.views.app.tips.tip.TipView;

public class TipRouterLink extends RouterLink {

    public static final String CLASS_NAME = "tip-router-link";

    public TipRouterLink(DogHubTip tip) {
        super(tip.getName(), TipView.class, tip.getId());
        addClassName(CLASS_NAME);
    }
}
