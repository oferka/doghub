package org.hk.doghub.ui.views.app.tips.tip;

import com.vaadin.flow.router.RouterLink;
import org.hk.doghub.model.tip.DogHubTip;
import org.hk.doghub.security.AuthenticatedUser;
import org.hk.doghub.ui.views.app.tips.TipsDataProvider;

import java.util.Optional;

public class NextTipRouterLink extends RouterLink {

    public static final String CLASS_NAME = "next-tip-router-link";

    private final NextTipButton nextTipButton;

    private final TipsDataProvider tipsDataProvider;

    private final AuthenticatedUser authenticatedUser;

    public NextTipRouterLink(TipsDataProvider tipsDataProvider, AuthenticatedUser authenticatedUser) {
        this.tipsDataProvider = tipsDataProvider;
        this.authenticatedUser = authenticatedUser;
        addClassName(CLASS_NAME);

        nextTipButton = new NextTipButton();
        nextTipButton.setEnabled(false);
        add(nextTipButton);
    }

    public void selectedTipChanged(long selectedTipId) {
        Optional<DogHubTip> tipOptional = tipsDataProvider.findNext(selectedTipId, authenticatedUser);
        if(tipOptional.isPresent()) {
            setRoute(TipView.class, tipOptional.get().getId());
            nextTipButton.setEnabled(true);
        }
        else {
            nextTipButton.setEnabled(false);
        }
    }
}
