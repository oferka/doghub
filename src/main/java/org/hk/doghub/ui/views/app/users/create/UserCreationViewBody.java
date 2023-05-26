package org.hk.doghub.ui.views.app.users.create;

import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import org.hk.doghub.security.AuthenticatedUser;
import org.hk.doghub.ui.components.shared.UserCreationContainer;
import org.hk.doghub.ui.components.shared.UserCreationService;

import static com.vaadin.flow.component.orderedlayout.FlexComponent.Alignment.CENTER;

public class UserCreationViewBody extends HorizontalLayout {

    public static final String CLASS_NAME = UserCreationView.CLASS_NAME + "-body";

    private final UserCreationContainer userCreationContainer;

    public UserCreationViewBody(AuthenticatedUser authenticatedUser, UserCreationService userCreationService) {
        addClassName(CLASS_NAME);

        setWidthFull();
        setAlignItems(CENTER);

        userCreationContainer = new UserCreationContainer(userCreationService);
        add(userCreationContainer);
    }
}
