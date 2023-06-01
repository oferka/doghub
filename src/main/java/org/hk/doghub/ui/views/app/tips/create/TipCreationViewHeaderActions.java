package org.hk.doghub.ui.views.app.tips.create;

import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import org.hk.doghub.security.AuthenticatedUser;

public class TipCreationViewHeaderActions extends HorizontalLayout {

    public static final String CLASS_NAME = TipCreationViewHeader.CLASS_NAME + "-actions";

    private final TipCreationViewHeaderActionsShareButton share;
    private final TipCreationViewHeaderActionsExportButton export;

    public TipCreationViewHeaderActions(AuthenticatedUser authenticatedUser, TipCreationService tipCreationService) {
        addClassName(CLASS_NAME);

        share = new TipCreationViewHeaderActionsShareButton(authenticatedUser, tipCreationService);
        add(share);

        export = new TipCreationViewHeaderActionsExportButton(authenticatedUser, tipCreationService);
        add(export);
    }
}
