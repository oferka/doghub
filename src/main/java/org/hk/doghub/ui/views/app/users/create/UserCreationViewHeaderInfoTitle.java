package org.hk.doghub.ui.views.app.users.create;

import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import org.hk.doghub.security.AuthenticatedUser;
import org.hk.doghub.ui.components.shared.user.UserCreationService;

import static com.vaadin.flow.component.orderedlayout.FlexComponent.Alignment.CENTER;

public class UserCreationViewHeaderInfoTitle extends HorizontalLayout {

    public static final String CLASS_NAME = UserCreationViewHeaderInfo.CLASS_NAME + "-title";

    public UserCreationViewHeaderInfoTitle(AuthenticatedUser authenticatedUser, UserCreationService userCreationService) {
        addClassName(CLASS_NAME);
        setAlignItems(CENTER);
        UserCreationViewHeaderInfoTitleIcon icon = new UserCreationViewHeaderInfoTitleIcon(authenticatedUser, userCreationService);
        UserCreationViewHeaderInfoTitleText text = new UserCreationViewHeaderInfoTitleText(authenticatedUser, userCreationService);
        add(icon, text);
        setVerticalComponentAlignment(CENTER, icon, text);
    }
}
