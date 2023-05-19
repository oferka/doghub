package org.hk.doghub.ui.views.app.tips;

import com.vaadin.flow.router.RouterLink;
import org.hk.doghub.model.DogHubTip;
import org.hk.doghub.security.AuthenticatedUser;
import org.hk.doghub.ui.views.app.tips.tip.TipView;

public class TipIdRouterLink extends RouterLink {

    public static final String CLASS_NAME = "tip-id-router-link";

    public TipIdRouterLink(DogHubTip tip, AuthenticatedUser authenticatedUser) {
        super(tip.getId().toString(), TipView.class, tip.getId());
        addClassName(CLASS_NAME);
    }
}
