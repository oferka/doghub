package org.hk.doghub.ui.views.app.tips.create;

import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import org.hk.doghub.security.AuthenticatedUser;

import static com.vaadin.flow.component.orderedlayout.FlexComponent.Alignment.CENTER;

public class TipCreationViewHeaderInfo extends VerticalLayout {

    public static final String CLASS_NAME = TipCreationViewHeader.CLASS_NAME + "-info";

    public TipCreationViewHeaderInfo(AuthenticatedUser authenticatedUser, TipCreationService tipCreationService) {
        addClassName(CLASS_NAME);
        setAlignItems(CENTER);
        TipCreationViewHeaderInfoTitle title = new TipCreationViewHeaderInfoTitle();
        TipCreationViewHeaderInfoDescription description = new TipCreationViewHeaderInfoDescription(authenticatedUser, tipCreationService);
        add(title, description);
    }
}
