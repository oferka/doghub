package org.hk.doghub.ui.views.app.tips.create;

import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import org.hk.doghub.model.tip.DogHubTip;
import org.hk.doghub.security.AuthenticatedUser;
import org.hk.doghub.ui.components.shared.tip.TipCreationContainerForm;
import org.hk.doghub.ui.components.shared.tip.TipCreationParameters;
import org.hk.doghub.ui.components.shared.user.EntityCreationContainer;

import static com.vaadin.flow.component.orderedlayout.FlexComponent.Alignment.CENTER;

public class TipCreationViewBody extends HorizontalLayout {

    public static final String CLASS_NAME = TipCreationView.CLASS_NAME + "-body";

    public TipCreationViewBody(AuthenticatedUser authenticatedUser, TipCreationService tipCreationService) {
        addClassName(CLASS_NAME);
        setWidthFull();
        setAlignItems(CENTER);
        EntityCreationContainer<DogHubTip, TipCreationParameters> creationContainer = new EntityCreationContainer<>(new TipCreationContainerForm(authenticatedUser, tipCreationService));
        add(creationContainer);
    }
}
