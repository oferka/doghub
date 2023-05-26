package org.hk.doghub.ui.views.site.signup;

import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import org.hk.doghub.ui.components.shared.UserCreationContainer;
import org.hk.doghub.ui.components.shared.UserCreationService;

import static com.vaadin.flow.component.orderedlayout.FlexComponent.Alignment.CENTER;

public class SignupBody extends VerticalLayout {

    public static final String CLASS_NAME = "signup-body";

    private final SignupWith signupWith;

    private final SignupDivider signupDivider;

    private final UserCreationContainer userCreationContainer;

    private final SignupMessage signupMessage;

    public SignupBody(UserCreationService userCreationService) {
        addClassName(CLASS_NAME);

        setAlignItems(CENTER);

        signupWith = new SignupWith();
        add(signupWith);

        signupDivider = new SignupDivider();
        add(signupDivider);

        userCreationContainer = new UserCreationContainer(userCreationService);
        add(userCreationContainer);

        signupMessage = new SignupMessage();
        add(signupMessage);
    }
}
