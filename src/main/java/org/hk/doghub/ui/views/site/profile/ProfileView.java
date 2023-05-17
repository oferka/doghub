package org.hk.doghub.ui.views.site.profile;

import com.vaadin.flow.component.html.Span;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;
import jakarta.annotation.security.RolesAllowed;
import org.hk.doghub.ui.views.site.DogHubSiteLayout;

import static com.vaadin.flow.component.orderedlayout.FlexComponent.Alignment.CENTER;

@Route(value = ProfileView.ROUTE, layout = DogHubSiteLayout.class)
@PageTitle(ProfileView.NAME)
@RolesAllowed({"USER", "ADMIN"})
public class ProfileView extends VerticalLayout {

    public static final String ROUTE = "profile";
    public static final String ID_PREFIX = "profile";
    public static final String ID_SUFFIX = "-view";
    public static final String CLASS_NAME = ID_PREFIX + ID_SUFFIX;
    public static final String NAME = "Profile";

    public ProfileView() {
        addClassName(CLASS_NAME);
        setAlignItems(CENTER);
        Span text = new Span(NAME);
        text.addClassName(CLASS_NAME.concat("-text"));
        add(text);
    }
}
