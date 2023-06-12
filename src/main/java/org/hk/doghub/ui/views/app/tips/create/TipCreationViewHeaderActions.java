package org.hk.doghub.ui.views.app.tips.create;

import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import org.hk.doghub.ui.components.shared.EntityCreationViewHeaderActionsExportButton;
import org.hk.doghub.ui.components.shared.EntityCreationViewHeaderActionsShareButton;

public class TipCreationViewHeaderActions extends HorizontalLayout {

    public static final String CLASS_NAME = TipCreationViewHeader.CLASS_NAME + "-actions";

    public TipCreationViewHeaderActions() {
        addClassName(CLASS_NAME);
        EntityCreationViewHeaderActionsShareButton share = new EntityCreationViewHeaderActionsShareButton();
        EntityCreationViewHeaderActionsExportButton export = new EntityCreationViewHeaderActionsExportButton();
        add(share, export);
    }
}
