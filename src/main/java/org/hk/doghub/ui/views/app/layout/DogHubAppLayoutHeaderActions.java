package org.hk.doghub.ui.views.app.layout;

import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import org.hk.doghub.security.AuthenticatedUser;
import org.hk.doghub.ui.components.shared.user.UserMenuBar;

import static com.vaadin.flow.component.orderedlayout.FlexComponent.Alignment.CENTER;

public class DogHubAppLayoutHeaderActions extends HorizontalLayout {

    public static final String CLASS_NAME = DogHubAppLayoutHeader.CLASS_NAME + "-actions";

    public DogHubAppLayoutHeaderActions(AuthenticatedUser authenticatedUser) {
        addClassName(CLASS_NAME);
        DogHubAppLayoutUserProfileRouterLink profile = new DogHubAppLayoutUserProfileRouterLink();
        DogHubAppLayoutUserSettingsRouterLink settings = new DogHubAppLayoutUserSettingsRouterLink();
        DogHubAppLayoutUserNotificationsRouterLink notifications = new DogHubAppLayoutUserNotificationsRouterLink();
        DogHubAppLayoutUserHelpRouterLink help = new DogHubAppLayoutUserHelpRouterLink();
        UserMenuBar user = new UserMenuBar(authenticatedUser);
        add(profile, settings, notifications, help, user);
        setVerticalComponentAlignment(CENTER, profile, settings, notifications, help, user);
    }
}
