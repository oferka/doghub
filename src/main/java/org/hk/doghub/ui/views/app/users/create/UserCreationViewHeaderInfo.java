package org.hk.doghub.ui.views.app.users.create;

import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import org.hk.doghub.security.AuthenticatedUser;
import org.hk.doghub.ui.components.shared.user.UserCreationService;

import static com.vaadin.flow.component.orderedlayout.FlexComponent.Alignment.CENTER;

public class UserCreationViewHeaderInfo extends VerticalLayout {

    public static final String CLASS_NAME = UserCreationViewHeader.CLASS_NAME + "-info";

    public UserCreationViewHeaderInfo(AuthenticatedUser authenticatedUser, UserCreationService userCreationService) {
        addClassName(CLASS_NAME);
        setAlignItems(CENTER);
        UserCreationViewHeaderInfoTitle title = new UserCreationViewHeaderInfoTitle();
        UserCreationViewHeaderInfoDescription description = new UserCreationViewHeaderInfoDescription(authenticatedUser, userCreationService);
        add(title, description);
    }
}
