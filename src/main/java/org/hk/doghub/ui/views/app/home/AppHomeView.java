package org.hk.doghub.ui.views.app.home;

import com.vaadin.flow.component.html.Span;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;
import jakarta.annotation.security.RolesAllowed;
import org.hk.doghub.ui.views.app.DogHubAppLayout;

import static com.vaadin.flow.component.orderedlayout.FlexComponent.Alignment.CENTER;
import static org.hk.doghub.ui.views.app.home.AppHomeView.ROUTE;

@PageTitle(AppHomeView.NAME)
@Route(value = ROUTE, layout = DogHubAppLayout.class)
@RolesAllowed({"USER", "ADMIN"})
public class AppHomeView extends VerticalLayout {

    public static final String ROUTE = "app-home";
    public static final String ID_PREFIX = "app-home";
    public static final String ID_SUFFIX = "-view";
    public static final String CLASS_NAME = ID_PREFIX + ID_SUFFIX;
    public static final String NAME = "Application Home";

    public AppHomeView() {
        addClassName(CLASS_NAME);
        setAlignItems(CENTER);
        Span text = new Span(NAME);
        text.addClassName(CLASS_NAME.concat("-text"));
        add(text);
        setSizeFull();
        setJustifyContentMode(JustifyContentMode.CENTER);
        setDefaultHorizontalComponentAlignment(Alignment.CENTER);
        getStyle().set("text-align", "center");
    }
}
