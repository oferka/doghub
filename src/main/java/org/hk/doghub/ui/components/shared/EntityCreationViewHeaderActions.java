package org.hk.doghub.ui.components.shared;

import com.vaadin.flow.component.orderedlayout.HorizontalLayout;

public class EntityCreationViewHeaderActions extends HorizontalLayout {

    public static final String CLASS_NAME = "entity-creation-view-header-actions";

    public EntityCreationViewHeaderActions() {
        addClassName(CLASS_NAME);
        EntityCreationViewHeaderActionsShareButton share = new EntityCreationViewHeaderActionsShareButton();
        EntityCreationViewHeaderActionsExportButton export = new EntityCreationViewHeaderActionsExportButton();
        add(share, export);
    }
}
