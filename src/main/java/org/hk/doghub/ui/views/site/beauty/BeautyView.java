package org.hk.doghub.ui.views.site.beauty;

import com.vaadin.flow.component.html.Span;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;
import com.vaadin.flow.server.auth.AnonymousAllowed;
import org.hk.doghub.ui.views.site.DogHubSiteLayout;

import static com.vaadin.flow.component.orderedlayout.FlexComponent.Alignment.CENTER;

@Route(value = BeautyView.ROUTE, layout = DogHubSiteLayout.class)
@PageTitle(BeautyView.NAME)
@AnonymousAllowed
public class BeautyView extends VerticalLayout {

    public static final String ROUTE = "beauty";
    public static final String ID_PREFIX = "beauty";
    public static final String ID_SUFFIX = "-view";
    public static final String CLASS_NAME = ID_PREFIX + ID_SUFFIX;
    public static final String NAME = "Beauty";

    public BeautyView() {
        addClassName(CLASS_NAME);
        setAlignItems(CENTER);
        Span text = new Span(NAME);
        text.addClassName(CLASS_NAME.concat("-text"));
        add(text);
    }
}
