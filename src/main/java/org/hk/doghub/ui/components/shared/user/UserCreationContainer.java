package org.hk.doghub.ui.components.shared.user;

import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import lombok.extern.slf4j.Slf4j;
import org.hk.doghub.model.user.DogHubUser;
import org.hk.doghub.security.AuthenticatedUser;
import org.hk.doghub.ui.components.shared.*;

import static com.vaadin.flow.component.orderedlayout.FlexComponent.Alignment.CENTER;

@Slf4j
public class UserCreationContainer extends VerticalLayout implements InfoSaveListener {

    public static final String CLASS_NAME = "user-creation-container";

    private final EntityCreationContainerForm<DogHubUser, UserCreationParameters> form;

    public UserCreationContainer(AuthenticatedUser authenticatedUser, EntityCreationService<DogHubUser, UserCreationParameters> creationService) {
        addClassName(CLASS_NAME);
        setAlignItems(CENTER);
        form = new UserCreationContainerForm(authenticatedUser, creationService);
        EntityCreationButton create = new EntityCreationButton();
        create.addInfoSaveListener(this);
        add(form, create);
    }

    @Override
    public void saveTriggered(InfoSaveEvent event) {
        form.create();
    }
}
