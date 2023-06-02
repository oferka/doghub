package org.hk.doghub.ui.views.app.tips.create;

import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import org.hk.doghub.security.AuthenticatedUser;
import org.hk.doghub.ui.components.shared.tip.TipCreationContainer;

import static com.vaadin.flow.component.orderedlayout.FlexComponent.Alignment.CENTER;

public class TipCreationViewBody extends HorizontalLayout {

    public static final String CLASS_NAME = TipCreationView.CLASS_NAME + "-body";

    private final TipCreationContainer tipCreationContainer;

    public TipCreationViewBody(AuthenticatedUser authenticatedUser, TipCreationService tipCreationService) {
        addClassName(CLASS_NAME);

        setWidthFull();
        setAlignItems(CENTER);

        tipCreationContainer = new TipCreationContainer(authenticatedUser, tipCreationService);
        add(tipCreationContainer);
    }
}
