package org.hk.doghub.ui.views.app.users.create;

import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import org.hk.doghub.security.AuthenticatedUser;
import org.hk.doghub.ui.components.shared.UserCreationService;

import static com.vaadin.flow.component.orderedlayout.FlexComponent.Alignment.CENTER;

public class UserCreationViewHeaderInfoTitle extends HorizontalLayout {

    public static final String CLASS_NAME = UserCreationViewHeaderInfo.CLASS_NAME + "-title";

    private final UserCreationViewHeaderInfoTitleIcon icon;
    private final UserCreationViewHeaderInfoTitleText text;

    public UserCreationViewHeaderInfoTitle(AuthenticatedUser authenticatedUser, UserCreationService userCreationService) {
        addClassName(CLASS_NAME);

        setAlignItems(CENTER);

        icon = new UserCreationViewHeaderInfoTitleIcon(authenticatedUser, userCreationService);
        add(icon);

        text = new UserCreationViewHeaderInfoTitleText(authenticatedUser, userCreationService);
        add(text);

        setVerticalComponentAlignment(CENTER, icon, text);
    }
}
