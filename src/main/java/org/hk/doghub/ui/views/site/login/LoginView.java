package org.hk.doghub.ui.views.site.login;

import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.BeforeEnterEvent;
import com.vaadin.flow.router.BeforeEnterObserver;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;
import com.vaadin.flow.server.VaadinService;
import com.vaadin.flow.server.auth.AnonymousAllowed;
import lombok.extern.slf4j.Slf4j;
import org.hk.doghub.security.AuthenticatedUser;
import org.hk.doghub.ui.views.site.home.SiteHomeView;

import static com.vaadin.flow.router.internal.RouteUtil.getRoutePath;
import static org.hk.doghub.ui.views.site.login.LoginView.ROUTE;

@Slf4j
@PageTitle(LoginView.NAME)
@Route(value = ROUTE)
@AnonymousAllowed
public class LoginView extends VerticalLayout implements BeforeEnterObserver {

    public static final String ROUTE = "login";
    public static final String ID_PREFIX = "login";
    public static final String ID_SUFFIX = "-view";
    public static final String CLASS_NAME = ID_PREFIX + ID_SUFFIX;
    public static final String NAME = "Login";

    private final AuthenticatedUser authenticatedUser;

    private final LoginContainer container;

    public LoginView(AuthenticatedUser authenticatedUser) {
        this.authenticatedUser = authenticatedUser;
        addClassName(CLASS_NAME);

        container = new LoginContainer();
        container.setAction(getRoutePath(VaadinService.getCurrent().getContext(), getClass()));
        add(container);

        setSizeFull();
        setJustifyContentMode(JustifyContentMode.CENTER);
        setDefaultHorizontalComponentAlignment(Alignment.CENTER);
    }

    @Override
    public void beforeEnter(BeforeEnterEvent event) {
        if (authenticatedUser.get().isPresent()) {
            event.forwardTo(SiteHomeView.class);
        }
        container.setError(event);
    }
}
