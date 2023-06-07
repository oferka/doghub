package org.hk.doghub.ui.views.app.tips.tip;

import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import org.hk.doghub.model.tip.DogHubTip;
import org.hk.doghub.security.AuthenticatedUser;
import org.hk.doghub.ui.components.shared.EntityViewHeaderActionsExportButton;
import org.hk.doghub.ui.components.shared.EntityViewHeaderActionsShareButton;
import org.hk.doghub.ui.views.app.tips.TipDataProvider;

public class TipViewHeaderActions extends HorizontalLayout {

    public static final String CLASS_NAME = TipViewHeader.CLASS_NAME + "-actions";

    private final EntityViewHeaderActionsShareButton<DogHubTip> share;
    private final EntityViewHeaderActionsExportButton<DogHubTip> export;

    public TipViewHeaderActions(TipDataProvider tipDataProvider, AuthenticatedUser authenticatedUser) {
        addClassName(CLASS_NAME);

        share = new EntityViewHeaderActionsShareButton<>(tipDataProvider);
        add(share);

        export = new EntityViewHeaderActionsExportButton<>(tipDataProvider);
        add(export);
    }

    public void selectedTipChanged(long selectedTipId) {
        share.selectedEntityChanged(selectedTipId);
        export.selectedEntityChanged(selectedTipId);
    }
}
