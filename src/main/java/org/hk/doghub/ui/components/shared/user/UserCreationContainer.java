package org.hk.doghub.ui.components.shared.user;

import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import org.hk.doghub.security.AuthenticatedUser;

import static com.vaadin.flow.component.orderedlayout.FlexComponent.Alignment.CENTER;

public class UserCreationContainer extends VerticalLayout {

    public static final String CLASS_NAME = "user-creation-container";

    private final UserEmailField emailField;

    private final UserPasswordField passwordField;

    private final UserCreationButton button;

    public UserCreationContainer(AuthenticatedUser authenticatedUser, UserCreationService userCreationService) {
        addClassName(CLASS_NAME);

        setAlignItems(CENTER);

        emailField = new UserEmailField();
        add(emailField);

        passwordField = new UserPasswordField();
        add(passwordField);

        button = new UserCreationButton(emailField, passwordField, authenticatedUser, userCreationService);
        add(button);
    }
}
