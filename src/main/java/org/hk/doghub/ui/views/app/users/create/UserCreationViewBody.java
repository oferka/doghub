package org.hk.doghub.ui.views.app.users.create;

import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import org.hk.doghub.security.AuthenticatedUser;
import org.hk.doghub.ui.components.shared.user.UserCreationContainer;
import org.hk.doghub.ui.components.shared.user.UserCreationService;

import static com.vaadin.flow.component.orderedlayout.FlexComponent.Alignment.CENTER;

public class UserCreationViewBody extends HorizontalLayout {

    public static final String CLASS_NAME = UserCreationView.CLASS_NAME + "-body";

    public UserCreationViewBody(AuthenticatedUser authenticatedUser, UserCreationService userCreationService) {
        addClassName(CLASS_NAME);
        setWidthFull();
        setAlignItems(CENTER);
        UserCreationContainer userCreationContainer = new UserCreationContainer(authenticatedUser, userCreationService);
        add(userCreationContainer);
    }
}
