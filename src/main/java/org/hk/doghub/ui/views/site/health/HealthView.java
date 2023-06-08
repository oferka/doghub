package org.hk.doghub.ui.views.site.health;

import com.vaadin.flow.component.html.Span;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;
import com.vaadin.flow.server.auth.AnonymousAllowed;
import org.hk.doghub.ui.views.site.layout.DogHubSiteLayout;

import static com.vaadin.flow.component.orderedlayout.FlexComponent.Alignment.CENTER;

@Route(value = HealthView.ROUTE, layout = DogHubSiteLayout.class)
@PageTitle(HealthView.NAME)
@AnonymousAllowed
public class HealthView extends VerticalLayout {

    public static final String ROUTE = "health";
    private static final String ID_PREFIX = "health";
    private static final String ID_SUFFIX = "-view";
    public static final String CLASS_NAME = ID_PREFIX + ID_SUFFIX;
    public static final String NAME = "Health";

    public HealthView() {
        addClassName(CLASS_NAME);
        setAlignItems(CENTER);
        Span text = new Span(NAME);
        text.addClassName(CLASS_NAME.concat("-text"));
        add(text);
    }
}
