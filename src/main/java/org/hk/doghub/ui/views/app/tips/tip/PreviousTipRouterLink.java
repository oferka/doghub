package org.hk.doghub.ui.views.app.tips.tip;

import com.vaadin.flow.router.RouterLink;
import org.hk.doghub.model.tip.DogHubTip;
import org.hk.doghub.security.AuthenticatedUser;
import org.hk.doghub.ui.views.app.tips.TipsDataProvider;

import java.util.Optional;

public class PreviousTipRouterLink extends RouterLink {

    public static final String CLASS_NAME = "previous-tip-router-link";

    private final PreviousTipButton previousTipButton;

    private final TipsDataProvider tipsDataProvider;

    private final AuthenticatedUser authenticatedUser;

    public PreviousTipRouterLink(TipsDataProvider tipsDataProvider, AuthenticatedUser authenticatedUser) {
        this.tipsDataProvider = tipsDataProvider;
        this.authenticatedUser = authenticatedUser;
        addClassName(CLASS_NAME);

        previousTipButton = new PreviousTipButton();
        previousTipButton.setEnabled(false);
        add(previousTipButton);
    }

    public void selectedTipChanged(long selectedTipId) {
        Optional<DogHubTip> tipOptional = tipsDataProvider.findPrevious(selectedTipId, authenticatedUser);
        if(tipOptional.isPresent()) {
            setRoute(TipView.class, tipOptional.get().getId());
            previousTipButton.setEnabled(true);
        }
        else {
            previousTipButton.setEnabled(false);
        }
    }
}
