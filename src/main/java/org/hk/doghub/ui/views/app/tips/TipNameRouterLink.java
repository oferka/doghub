package org.hk.doghub.ui.views.app.tips;

import com.vaadin.flow.router.RouterLink;
import org.hk.doghub.model.tip.DogHubTip;
import org.hk.doghub.security.AuthenticatedUser;
import org.hk.doghub.ui.views.app.tips.tip.TipView;

public class TipNameRouterLink extends RouterLink {

    public static final String CLASS_NAME = "tip-name-router-link";

    public TipNameRouterLink(DogHubTip tip, AuthenticatedUser authenticatedUser) {
        super(tip.getName(), TipView.class, tip.getId());
        addClassName(CLASS_NAME);
    }
}
