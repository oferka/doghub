package org.hk.doghub.ui.views.app.layout;

import com.vaadin.flow.router.RouterLink;
import org.hk.doghub.ui.views.site.notifications.NotificationsView;

import static org.apache.commons.lang3.StringUtils.EMPTY;

public class DogHubAppLayoutUserNotificationsRouterLink extends RouterLink {

    public static final String CLASS_NAME = DogHubAppLayoutHeader.CLASS_NAME + "-user-notifications-router-link";

    private final DogHubAppLayoutUserNotificationsButton notificationsButton;

    public DogHubAppLayoutUserNotificationsRouterLink() {
        super(EMPTY, NotificationsView.class);
        addClassName(CLASS_NAME);

        notificationsButton = new DogHubAppLayoutUserNotificationsButton();
        add(notificationsButton);
    }
}
