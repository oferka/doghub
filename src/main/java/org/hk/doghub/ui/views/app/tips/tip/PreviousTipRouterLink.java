package org.hk.doghub.ui.views.app.tips.tip;

import com.vaadin.flow.router.RouterLink;
import org.hk.doghub.model.tip.DogHubTip;
import org.hk.doghub.security.AuthenticatedUser;
import org.hk.doghub.ui.components.shared.PreviousEntityButton;
import org.hk.doghub.ui.views.app.tips.TipDataProvider;

import java.util.Optional;

public class PreviousTipRouterLink extends RouterLink {

    public static final String CLASS_NAME = "previous-tip-router-link";

    private final PreviousEntityButton previousEntityButton;

    private final TipDataProvider tipDataProvider;

    private final AuthenticatedUser authenticatedUser;

    public PreviousTipRouterLink(TipDataProvider tipDataProvider, AuthenticatedUser authenticatedUser) {
        this.tipDataProvider = tipDataProvider;
        this.authenticatedUser = authenticatedUser;
        addClassName(CLASS_NAME);

        previousEntityButton = new PreviousEntityButton("Previous Tip");
        previousEntityButton.setEnabled(false);
        add(previousEntityButton);
    }

    public void selectedTipChanged(long selectedTipId) {
        Optional<DogHubTip> tipOptional = tipDataProvider.findPrevious(authenticatedUser, selectedTipId);
        if(tipOptional.isPresent()) {
            setRoute(TipView.class, tipOptional.get().getId());
            previousEntityButton.setEnabled(true);
        }
        else {
            previousEntityButton.setEnabled(false);
        }
    }
}
