package org.hk.doghub.ui.views.app.layout;

import com.vaadin.flow.router.RouterLink;
import jakarta.validation.constraints.NotNull;
import org.hk.doghub.ui.views.site.notifications.NotificationsView;

public class NotificationsRouterLink extends RouterLink {

    public static final String CLASS_NAME = "notifications-router-link";

    public NotificationsRouterLink(@NotNull String text) {
        super(text, NotificationsView.class);
        addClassName(CLASS_NAME);
        NotificationsButton notifications = new NotificationsButton();
        add(notifications);
    }
}
