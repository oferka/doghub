package org.hk.doghub.ui.components.shared.tip;

import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import lombok.extern.slf4j.Slf4j;
import org.hk.doghub.model.tip.DogHubTip;
import org.hk.doghub.security.AuthenticatedUser;
import org.hk.doghub.ui.components.shared.*;

import static com.vaadin.flow.component.orderedlayout.FlexComponent.Alignment.CENTER;

@Slf4j
public class TipCreationContainer extends VerticalLayout implements InfoSaveListener {

    public static final String CLASS_NAME = "tip-creation-container";

    private final EntityCreationContainerForm<DogHubTip, TipCreationParameters> form;

    public TipCreationContainer(AuthenticatedUser authenticatedUser, EntityCreationService<DogHubTip, TipCreationParameters> creationService) {
        addClassName(CLASS_NAME);
        setAlignItems(CENTER);
        form = new TipCreationContainerForm(authenticatedUser, creationService);
        EntityCreationButton create = new EntityCreationButton();
        create.addInfoSaveListener(this);
        add(form, create);
    }

    @Override
    public void saveTriggered(InfoSaveEvent event) {
        form.create();
    }
}
