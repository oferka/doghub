package org.hk.doghub.ui.views.app.tips.tip;

import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import org.hk.doghub.security.AuthenticatedUser;
import org.hk.doghub.ui.views.app.tips.TipsDataProvider;

public class TipViewHeaderActions extends HorizontalLayout {

    public static final String CLASS_NAME = TipViewHeader.CLASS_NAME + "-actions";

    private final TipViewHeaderActionsShareButton tipViewHeaderActionsShareButton;
    private final TipViewHeaderActionsExportButton tipViewHeaderActionsExportButton;

    public TipViewHeaderActions(TipsDataProvider tipsDataProvider, AuthenticatedUser authenticatedUser) {
        addClassName(CLASS_NAME);

        tipViewHeaderActionsShareButton = new TipViewHeaderActionsShareButton(tipsDataProvider, authenticatedUser);
        add(tipViewHeaderActionsShareButton);

        tipViewHeaderActionsExportButton = new TipViewHeaderActionsExportButton(tipsDataProvider, authenticatedUser);
        add(tipViewHeaderActionsExportButton);
    }

    public void selectedTipChanged(long selectedTipId) {
        tipViewHeaderActionsShareButton.selectedTipChanged(selectedTipId);
        tipViewHeaderActionsExportButton.selectedTipChanged(selectedTipId);
    }
}
