package org.hk.doghub.ui.views.app.tips;

import com.vaadin.flow.router.RouterLink;
import org.hk.doghub.model.DogHubTip;
import org.hk.doghub.security.AuthenticatedUser;
import org.hk.doghub.ui.views.app.tips.tip.TipView;

public class TipRouterLink extends RouterLink {

    public static final String CLASS_NAME = "tip-router-link";

    public TipRouterLink(DogHubTip tip, AuthenticatedUser authenticatedUser) {
        super(tip.getName(), TipView.class, tip.getId());
        addClassName(CLASS_NAME);
    }
}
