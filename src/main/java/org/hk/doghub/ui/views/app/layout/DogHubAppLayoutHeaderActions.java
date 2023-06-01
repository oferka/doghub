package org.hk.doghub.ui.views.app.layout;

import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import org.hk.doghub.security.AuthenticatedUser;
import org.hk.doghub.ui.components.shared.user.UserMenuBar;

import static com.vaadin.flow.component.orderedlayout.FlexComponent.Alignment.CENTER;

public class DogHubAppLayoutHeaderActions extends HorizontalLayout {

    public static final String CLASS_NAME = DogHubAppLayoutHeader.CLASS_NAME + "-actions";
    private final DogHubAppLayoutUserProfileRouterLink profile;
    private final DogHubAppLayoutUserSettingsRouterLink settings;
    private final DogHubAppLayoutUserNotificationsRouterLink notifications;
    private final DogHubAppLayoutUserHelpRouterLink help;
    private final UserMenuBar user;

    public DogHubAppLayoutHeaderActions(AuthenticatedUser authenticatedUser) {
        addClassName(CLASS_NAME);
        profile = new DogHubAppLayoutUserProfileRouterLink();
        settings = new DogHubAppLayoutUserSettingsRouterLink();
        notifications = new DogHubAppLayoutUserNotificationsRouterLink();
        help = new DogHubAppLayoutUserHelpRouterLink();
        user = new UserMenuBar(authenticatedUser);
        add(profile, settings, notifications, help, user);
        setVerticalComponentAlignment(CENTER, profile, settings, notifications, help, user);
    }
}
