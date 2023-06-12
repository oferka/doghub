package org.hk.doghub.ui.views.app.users.create;

import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import org.hk.doghub.ui.components.shared.EntityCreationViewHeaderActionsExportButton;
import org.hk.doghub.ui.components.shared.EntityCreationViewHeaderActionsShareButton;

public class UserCreationViewHeaderActions extends HorizontalLayout {

    public static final String CLASS_NAME = UserCreationViewHeader.CLASS_NAME + "-actions";

    public UserCreationViewHeaderActions() {
        addClassName(CLASS_NAME);
        EntityCreationViewHeaderActionsShareButton share = new EntityCreationViewHeaderActionsShareButton();
        EntityCreationViewHeaderActionsExportButton export = new EntityCreationViewHeaderActionsExportButton();
        add(share, export);
    }
}
