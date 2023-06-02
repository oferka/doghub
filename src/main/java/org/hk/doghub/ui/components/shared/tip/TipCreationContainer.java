package org.hk.doghub.ui.components.shared.tip;

import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import org.hk.doghub.security.AuthenticatedUser;
import org.hk.doghub.ui.views.app.tips.create.TipCreationService;

import static com.vaadin.flow.component.orderedlayout.FlexComponent.Alignment.CENTER;

public class TipCreationContainer extends VerticalLayout {

    public static final String CLASS_NAME = "tip-creation-container";

    private final TipTitleField title;

    private final TipCreationButton create;

    public TipCreationContainer(AuthenticatedUser authenticatedUser, TipCreationService tipCreationService) {
        addClassName(CLASS_NAME);

        setAlignItems(CENTER);

        title = new TipTitleField();
        add(title);

        create = new TipCreationButton(title, authenticatedUser, tipCreationService);
        add(create);
    }
}
