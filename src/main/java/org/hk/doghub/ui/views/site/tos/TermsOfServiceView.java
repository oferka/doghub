package org.hk.doghub.ui.views.site.tos;

import com.vaadin.flow.component.html.Span;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;
import com.vaadin.flow.server.auth.AnonymousAllowed;
import org.hk.doghub.ui.views.site.layout.DogHubSiteLayout;

import static com.vaadin.flow.component.orderedlayout.FlexComponent.Alignment.CENTER;

@Route(value = TermsOfServiceView.ROUTE, layout = DogHubSiteLayout.class)
@PageTitle(TermsOfServiceView.NAME)
@AnonymousAllowed
public class TermsOfServiceView extends VerticalLayout {

    public static final String ROUTE = "tos";
    private static final String ID_PREFIX = "terms-of-service";
    private static final String ID_SUFFIX = "-view";
    public static final String CLASS_NAME = ID_PREFIX + ID_SUFFIX;
    public static final String NAME = "Terms of Service";

    public TermsOfServiceView() {
        addClassName(CLASS_NAME);
        setAlignItems(CENTER);
        Span text = new Span(NAME);
        text.addClassName(CLASS_NAME.concat("-text"));
        add(text);
    }
}
