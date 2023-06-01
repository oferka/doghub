package org.hk.doghub.ui.views.app.tips.create;

import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import org.hk.doghub.security.AuthenticatedUser;

import static com.vaadin.flow.component.orderedlayout.FlexComponent.Alignment.CENTER;

public class TipCreationViewHeaderInfo extends VerticalLayout {

    public static final String CLASS_NAME = TipCreationViewHeader.CLASS_NAME + "-info";

    private final TipCreationViewHeaderInfoTitle title;
    private final TipCreationViewHeaderInfoDescription description;

    public TipCreationViewHeaderInfo(AuthenticatedUser authenticatedUser, TipCreationService tipCreationService) {
        addClassName(CLASS_NAME);

        setAlignItems(CENTER);

        title = new TipCreationViewHeaderInfoTitle(authenticatedUser, tipCreationService);
        add(title);

        description = new TipCreationViewHeaderInfoDescription(authenticatedUser, tipCreationService);
        add(description);
    }
}
