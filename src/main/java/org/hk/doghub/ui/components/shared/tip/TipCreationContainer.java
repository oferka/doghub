package org.hk.doghub.ui.components.shared.tip;

import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import org.hk.doghub.security.AuthenticatedUser;
import org.hk.doghub.ui.views.app.tips.create.TipCreationService;

import static com.vaadin.flow.component.orderedlayout.FlexComponent.Alignment.CENTER;

public class TipCreationContainer extends VerticalLayout {

    public static final String CLASS_NAME = "tip-creation-container";

    public TipCreationContainer(AuthenticatedUser authenticatedUser, TipCreationService tipCreationService) {
        addClassName(CLASS_NAME);
        setAlignItems(CENTER);
        TipTitleField title = new TipTitleField();
        TipCreationButton create = new TipCreationButton(title, authenticatedUser, tipCreationService);
        add(title, create);
    }
}
