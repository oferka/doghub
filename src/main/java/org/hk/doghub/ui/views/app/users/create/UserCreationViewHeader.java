package org.hk.doghub.ui.views.app.users.create;

import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import org.hk.doghub.security.AuthenticatedUser;
import org.hk.doghub.ui.components.shared.EntityCreationViewHeaderInfo;
import org.hk.doghub.ui.components.shared.user.UserCreationService;

import static com.vaadin.flow.component.icon.VaadinIcon.USERS;
import static com.vaadin.flow.component.orderedlayout.FlexComponent.Alignment.CENTER;

public class UserCreationViewHeader extends HorizontalLayout {

    public static final String CLASS_NAME = UserCreationView.CLASS_NAME + "-header";

    public UserCreationViewHeader(AuthenticatedUser authenticatedUser, UserCreationService userCreationService) {
        addClassName(CLASS_NAME);
        setWidthFull();
        setAlignItems(CENTER);
        EntityCreationViewHeaderInfo info = new EntityCreationViewHeaderInfo(USERS, "Create a User", "Add someone you love to DogHub");
        UserCreationViewHeaderActions actions = new UserCreationViewHeaderActions(authenticatedUser, userCreationService);
        add(info, actions);
    }
}
