package org.hk.doghub.ui.views.site.home;

import com.vaadin.flow.component.html.Span;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;
import com.vaadin.flow.router.RouteAlias;
import com.vaadin.flow.server.auth.AnonymousAllowed;
import org.hk.doghub.ui.views.site.layout.DogHubSiteLayout;

import static com.vaadin.flow.component.orderedlayout.FlexComponent.Alignment.CENTER;
import static org.apache.commons.lang3.StringUtils.EMPTY;
import static org.hk.doghub.ui.views.site.home.SiteHomeView.ROUTE;

@Route(value = ROUTE, layout = DogHubSiteLayout.class)
@RouteAlias(value = EMPTY, layout = DogHubSiteLayout.class)
@PageTitle(SiteHomeView.NAME)
@AnonymousAllowed
public class SiteHomeView extends VerticalLayout {

    public static final String ROUTE = "site-home";
    private static final String ID_PREFIX = "site-home";
    private static final String ID_SUFFIX = "-view";
    public static final String CLASS_NAME = ID_PREFIX + ID_SUFFIX;
    public static final String NAME = "Site Home";

    public SiteHomeView() {
        addClassName(CLASS_NAME);
        setAlignItems(CENTER);
        Span text = new Span(NAME);
        text.addClassName(CLASS_NAME.concat("-text"));
        add(text);
    }
}
