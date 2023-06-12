package org.hk.doghub.ui.components.shared.user;

import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import org.hk.doghub.security.AuthenticatedUser;

import static com.vaadin.flow.component.orderedlayout.FlexComponent.Alignment.CENTER;

public class UserCreationContainer extends VerticalLayout {

    public static final String CLASS_NAME = "user-creation-container";

    public UserCreationContainer(AuthenticatedUser authenticatedUser, UserCreationService userCreationService) {
        addClassName(CLASS_NAME);
        setAlignItems(CENTER);
        UserEmailField email = new UserEmailField();
        UserPasswordField password = new UserPasswordField();
        UserCreationButton create = new UserCreationButton(email, password, authenticatedUser, userCreationService);
        add(email, password, create);
    }
}
