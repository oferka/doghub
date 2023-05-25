package org.hk.doghub.ui.views.app.users.create;

import com.vaadin.flow.component.icon.Icon;
import org.hk.doghub.security.AuthenticatedUser;

import static com.vaadin.flow.component.icon.VaadinIcon.USER;

public class UserCreationViewHeaderInfoTitleIcon extends Icon {

    public static final String CLASS_NAME = UserCreationViewHeaderInfoTitle.CLASS_NAME + "-icon";

    public UserCreationViewHeaderInfoTitleIcon(AuthenticatedUser authenticatedUser, UserCreationService userCreationService) {
        super(USER);
        addClassName(CLASS_NAME);
    }
}
