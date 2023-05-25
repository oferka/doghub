package org.hk.doghub.ui.views.app.users.create;

import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import org.hk.doghub.security.AuthenticatedUser;

import static com.vaadin.flow.component.orderedlayout.FlexComponent.Alignment.CENTER;

public class UserCreationViewHeader extends HorizontalLayout {

    public static final String CLASS_NAME = UserCreationView.CLASS_NAME + "-header";

    private final UserCreationViewHeaderInfo info;
//    private final UserCreationViewHeaderActions actions;

    public UserCreationViewHeader(AuthenticatedUser authenticatedUser, UserCreationService userCreationService) {
        addClassName(CLASS_NAME);

        setWidthFull();
        setAlignItems(CENTER);

        info = new UserCreationViewHeaderInfo(authenticatedUser, userCreationService);
        add(info);

//        actions = new UserCreationViewHeaderActions(authenticatedUser, userCreationService);
//        add(actions);
    }
}
