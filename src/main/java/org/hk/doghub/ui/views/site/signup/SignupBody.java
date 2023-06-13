package org.hk.doghub.ui.views.site.signup;

import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import org.hk.doghub.model.user.DogHubUser;
import org.hk.doghub.security.AuthenticatedUser;
import org.hk.doghub.ui.components.shared.user.EntityCreationContainer;
import org.hk.doghub.ui.components.shared.user.UserCreationContainerForm;
import org.hk.doghub.ui.components.shared.user.UserCreationParameters;
import org.hk.doghub.ui.components.shared.user.UserCreationService;

import static com.vaadin.flow.component.orderedlayout.FlexComponent.Alignment.CENTER;

public class SignupBody extends VerticalLayout {

    public static final String CLASS_NAME = "signup-body";

    public SignupBody(AuthenticatedUser authenticatedUser, UserCreationService userCreationService) {
        addClassName(CLASS_NAME);
        setAlignItems(CENTER);
        SignupWith signupWith = new SignupWith();
        SignupDivider signupDivider = new SignupDivider();
        EntityCreationContainer<DogHubUser, UserCreationParameters> creationContainer = new EntityCreationContainer<>(new UserCreationContainerForm(authenticatedUser, userCreationService));
        SignupMessage signupMessage = new SignupMessage();
        add(signupWith, signupDivider, creationContainer, signupMessage);
    }
}
