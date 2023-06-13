package org.hk.doghub.ui.views.app.users.create;

import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import org.hk.doghub.model.user.DogHubUser;
import org.hk.doghub.security.AuthenticatedUser;
import org.hk.doghub.ui.components.shared.user.EntityCreationContainer;
import org.hk.doghub.ui.components.shared.user.UserCreationContainerForm;
import org.hk.doghub.ui.components.shared.user.UserCreationParameters;
import org.hk.doghub.ui.components.shared.user.UserCreationService;

import static com.vaadin.flow.component.orderedlayout.FlexComponent.Alignment.CENTER;

public class UserCreationViewBody extends HorizontalLayout {

    public static final String CLASS_NAME = UserCreationView.CLASS_NAME + "-body";

    public UserCreationViewBody(AuthenticatedUser authenticatedUser, UserCreationService userCreationService) {
        addClassName(CLASS_NAME);
        setWidthFull();
        setAlignItems(CENTER);
        EntityCreationContainer<DogHubUser, UserCreationParameters> creationContainer = new EntityCreationContainer<>(new UserCreationContainerForm(authenticatedUser, userCreationService));
        add(creationContainer);
    }
}
