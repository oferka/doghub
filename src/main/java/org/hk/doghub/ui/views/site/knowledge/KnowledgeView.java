package org.hk.doghub.ui.views.site.knowledge;

import com.vaadin.flow.component.html.Span;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;
import com.vaadin.flow.server.auth.AnonymousAllowed;
import org.hk.doghub.ui.views.site.layout.DogHubSiteLayout;

import static com.vaadin.flow.component.orderedlayout.FlexComponent.Alignment.CENTER;

@Route(value = KnowledgeView.ROUTE, layout = DogHubSiteLayout.class)
@PageTitle(KnowledgeView.NAME)
@AnonymousAllowed
public class KnowledgeView extends VerticalLayout {

    public static final String ROUTE = "knowledge";
    private static final String ID_PREFIX = "knowledge";
    private static final String ID_SUFFIX = "-view";
    public static final String CLASS_NAME = ID_PREFIX + ID_SUFFIX;
    public static final String NAME = "Knowledge";

    public KnowledgeView() {
        addClassName(CLASS_NAME);
        setAlignItems(CENTER);
        Span text = new Span(NAME);
        text.addClassName(CLASS_NAME.concat("-text"));
        add(text);
    }
}
