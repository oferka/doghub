package org.hk.doghub.ui.views.app.layout;

import com.vaadin.flow.router.RouterLink;
import org.hk.doghub.ui.views.site.notifications.NotificationsView;

import static org.apache.commons.lang3.StringUtils.EMPTY;

public class DogHubAppLayoutUserNotificationsRouterLink extends RouterLink {

    public static final String CLASS_NAME = DogHubAppLayoutHeader.CLASS_NAME + "-user-notifications-router-link";

    public DogHubAppLayoutUserNotificationsRouterLink() {
        super(EMPTY, NotificationsView.class);
        addClassName(CLASS_NAME);
        DogHubAppLayoutUserNotificationsButton notifications = new DogHubAppLayoutUserNotificationsButton();
        add(notifications);
    }
}
