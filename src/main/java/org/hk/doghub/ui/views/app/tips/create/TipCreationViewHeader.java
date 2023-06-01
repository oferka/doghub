package org.hk.doghub.ui.views.app.tips.create;

import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import org.hk.doghub.security.AuthenticatedUser;

import static com.vaadin.flow.component.orderedlayout.FlexComponent.Alignment.CENTER;

public class TipCreationViewHeader extends HorizontalLayout {

    public static final String CLASS_NAME = TipCreationView.CLASS_NAME + "-header";

    private final TipCreationViewHeaderInfo info;
    private final TipCreationViewHeaderActions actions;

    public TipCreationViewHeader(AuthenticatedUser authenticatedUser, TipCreationService tipCreationService) {
        addClassName(CLASS_NAME);

        setWidthFull();
        setAlignItems(CENTER);

        info = new TipCreationViewHeaderInfo(authenticatedUser, tipCreationService);
        add(info);

        actions = new TipCreationViewHeaderActions(authenticatedUser, tipCreationService);
        add(actions);
    }
}
