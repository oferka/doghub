package org.hk.doghub.ui.views.app.tips.tip;

import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import org.hk.doghub.security.AuthenticatedUser;
import org.hk.doghub.ui.views.app.tips.TipsDataProvider;

public class TipViewHeaderActions extends HorizontalLayout {

    public static final String CLASS_NAME = TipViewHeader.CLASS_NAME + "-actions";

    private final TipViewHeaderActionsShareButton share;
    private final TipViewHeaderActionsExportButton export;

    public TipViewHeaderActions(TipsDataProvider tipsDataProvider, AuthenticatedUser authenticatedUser) {
        addClassName(CLASS_NAME);

        share = new TipViewHeaderActionsShareButton(tipsDataProvider, authenticatedUser);
        add(share);

        export = new TipViewHeaderActionsExportButton(tipsDataProvider, authenticatedUser);
        add(export);
    }

    public void selectedTipChanged(long selectedTipId) {
        share.selectedTipChanged(selectedTipId);
        export.selectedTipChanged(selectedTipId);
    }
}
