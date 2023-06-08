package org.hk.doghub.ui.views.site.notifications;

import com.vaadin.flow.component.html.Span;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;
import jakarta.annotation.security.RolesAllowed;
import org.hk.doghub.ui.views.site.layout.DogHubSiteLayout;

import static com.vaadin.flow.component.orderedlayout.FlexComponent.Alignment.CENTER;

@Route(value = NotificationsView.ROUTE, layout = DogHubSiteLayout.class)
@PageTitle(NotificationsView.NAME)
@RolesAllowed({"USER", "ADMIN"})
public class NotificationsView extends VerticalLayout {

    public static final String ROUTE = "notifications";
    private static final String ID_PREFIX = "notifications";
    private static final String ID_SUFFIX = "-view";
    public static final String CLASS_NAME = ID_PREFIX + ID_SUFFIX;
    public static final String NAME = "Notifications";

    public NotificationsView() {
        addClassName(CLASS_NAME);
        setAlignItems(CENTER);
        Span text = new Span(NAME);
        text.addClassName(CLASS_NAME.concat("-text"));
        add(text);
    }
}
