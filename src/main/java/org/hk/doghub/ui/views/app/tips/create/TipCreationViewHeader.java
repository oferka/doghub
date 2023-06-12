package org.hk.doghub.ui.views.app.tips.create;

import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import org.hk.doghub.security.AuthenticatedUser;
import org.hk.doghub.ui.components.shared.EntityCreationViewHeaderInfo;

import static com.vaadin.flow.component.icon.VaadinIcon.LINK;
import static com.vaadin.flow.component.orderedlayout.FlexComponent.Alignment.CENTER;

public class TipCreationViewHeader extends HorizontalLayout {

    public static final String CLASS_NAME = TipCreationView.CLASS_NAME + "-header";

    public TipCreationViewHeader(AuthenticatedUser authenticatedUser, TipCreationService tipCreationService) {
        addClassName(CLASS_NAME);
        setWidthFull();
        setAlignItems(CENTER);
        EntityCreationViewHeaderInfo info = new EntityCreationViewHeaderInfo(LINK, "Create a Tip", "Add some interesting tip to DogHub");
        TipCreationViewHeaderActions actions = new TipCreationViewHeaderActions(authenticatedUser, tipCreationService);
        add(info, actions);
    }
}
