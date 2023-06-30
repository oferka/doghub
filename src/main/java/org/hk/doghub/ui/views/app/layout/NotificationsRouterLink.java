package org.hk.doghub.ui.views.app.layout;

import com.vaadin.flow.router.RouterLink;
import jakarta.validation.constraints.NotNull;
import org.hk.doghub.ui.views.site.notifications.NotificationsView;

import static org.apache.commons.lang3.StringUtils.EMPTY;

public class NotificationsRouterLink extends RouterLink {

    public static final String CLASS_NAME = "notifications-router-link";

    public NotificationsRouterLink(@NotNull String text) {
        super(EMPTY, NotificationsView.class);
        addClassName(CLASS_NAME);
        NotificationsButton notifications = new NotificationsButton(text);
        add(notifications);
    }
}
