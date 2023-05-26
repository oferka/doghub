package org.hk.doghub.ui.views.app.users.create;

import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import org.hk.doghub.security.AuthenticatedUser;
import org.hk.doghub.ui.components.shared.UserCreationService;

import static com.vaadin.flow.component.orderedlayout.FlexComponent.Alignment.CENTER;

public class UserCreationViewHeaderInfo extends VerticalLayout {

    public static final String CLASS_NAME = UserCreationViewHeader.CLASS_NAME + "-info";

    private final UserCreationViewHeaderInfoTitle title;
    private final UserCreationViewHeaderInfoDescription description;

    public UserCreationViewHeaderInfo(AuthenticatedUser authenticatedUser, UserCreationService userCreationService) {
        addClassName(CLASS_NAME);

        setAlignItems(CENTER);

        title = new UserCreationViewHeaderInfoTitle(authenticatedUser, userCreationService);
        add(title);

        description = new UserCreationViewHeaderInfoDescription(authenticatedUser, userCreationService);
        add(description);
    }
}
