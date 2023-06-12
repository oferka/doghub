package org.hk.doghub.ui.views.app.users.create;

import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import org.hk.doghub.security.AuthenticatedUser;
import org.hk.doghub.ui.components.shared.user.UserCreationService;

import static com.vaadin.flow.component.orderedlayout.FlexComponent.Alignment.CENTER;

public class UserCreationViewHeader extends HorizontalLayout {

    public static final String CLASS_NAME = UserCreationView.CLASS_NAME + "-header";

    public UserCreationViewHeader(AuthenticatedUser authenticatedUser, UserCreationService userCreationService) {
        addClassName(CLASS_NAME);
        setWidthFull();
        setAlignItems(CENTER);
        UserCreationViewHeaderInfo info = new UserCreationViewHeaderInfo(authenticatedUser, userCreationService);
        UserCreationViewHeaderActions actions = new UserCreationViewHeaderActions(authenticatedUser, userCreationService);
        add(info, actions);
    }
}
