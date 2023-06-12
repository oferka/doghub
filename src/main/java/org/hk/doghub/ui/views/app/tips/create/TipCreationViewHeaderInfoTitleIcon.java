package org.hk.doghub.ui.views.app.tips.create;

import com.vaadin.flow.component.icon.Icon;
import org.hk.doghub.security.AuthenticatedUser;

import static com.vaadin.flow.component.icon.VaadinIcon.LINK;

public class TipCreationViewHeaderInfoTitleIcon extends Icon {

    public static final String CLASS_NAME = TipCreationViewHeaderInfoTitle.CLASS_NAME + "-icon";

    public TipCreationViewHeaderInfoTitleIcon() {
        super(LINK);
        addClassName(CLASS_NAME);
    }
}
