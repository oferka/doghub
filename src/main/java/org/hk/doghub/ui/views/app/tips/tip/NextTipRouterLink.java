package org.hk.doghub.ui.views.app.tips.tip;

import com.vaadin.flow.router.RouterLink;
import org.hk.doghub.model.tip.DogHubTip;
import org.hk.doghub.security.AuthenticatedUser;
import org.hk.doghub.ui.views.app.tips.TipDataProvider;

import java.util.Optional;

public class NextTipRouterLink extends RouterLink {

    public static final String CLASS_NAME = "next-tip-router-link";

    private final NextTipButton nextTipButton;

    private final TipDataProvider tipDataProvider;

    private final AuthenticatedUser authenticatedUser;

    public NextTipRouterLink(TipDataProvider tipDataProvider, AuthenticatedUser authenticatedUser) {
        this.tipDataProvider = tipDataProvider;
        this.authenticatedUser = authenticatedUser;
        addClassName(CLASS_NAME);

        nextTipButton = new NextTipButton();
        nextTipButton.setEnabled(false);
        add(nextTipButton);
    }

    public void selectedTipChanged(long selectedTipId) {
        Optional<DogHubTip> tipOptional = tipDataProvider.findNext(authenticatedUser, selectedTipId);
        if(tipOptional.isPresent()) {
            setRoute(TipView.class, tipOptional.get().getId());
            nextTipButton.setEnabled(true);
        }
        else {
            nextTipButton.setEnabled(false);
        }
    }
}
