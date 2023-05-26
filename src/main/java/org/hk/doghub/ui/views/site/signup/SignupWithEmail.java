package org.hk.doghub.ui.views.site.signup;

import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import lombok.extern.slf4j.Slf4j;
import org.hk.doghub.ui.components.shared.UserCreationButton;
import org.hk.doghub.ui.components.shared.UserCreationService;
import org.hk.doghub.ui.components.shared.UserEmailField;
import org.hk.doghub.ui.components.shared.UserPasswordField;

import static com.vaadin.flow.component.orderedlayout.FlexComponent.Alignment.CENTER;

@Slf4j
public class SignupWithEmail extends VerticalLayout {

    public static final String CLASS_NAME = SignupBody.CLASS_NAME + "-signup-with-email";

    private final UserEmailField emailField;

    private final UserPasswordField passwordField;

    private final UserCreationButton button;

    public SignupWithEmail(UserCreationService userCreationService) {
        addClassName(CLASS_NAME);

        setAlignItems(CENTER);

        emailField = new UserEmailField();
        add(emailField);

        passwordField = new UserPasswordField();
        add(passwordField);

        button = new UserCreationButton(emailField, passwordField, userCreationService);
        add(button);
    }
}
