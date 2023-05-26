package org.hk.doghub.ui.components.shared;

import com.vaadin.flow.component.orderedlayout.VerticalLayout;

import static com.vaadin.flow.component.orderedlayout.FlexComponent.Alignment.CENTER;

public class UserRegistrationDetailsContainer extends VerticalLayout {

    public static final String CLASS_NAME = "user-registration-details-container";

    private final UserEmailField email;

    private final UserPasswordField password;

    public UserRegistrationDetailsContainer() {
        addClassName(CLASS_NAME);

        setAlignItems(CENTER);

        email = new UserEmailField();
        add(email);

        password = new UserPasswordField();
        add(password);
    }
}
