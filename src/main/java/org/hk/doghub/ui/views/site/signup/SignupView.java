package org.hk.doghub.ui.views.site.signup;

import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.BeforeEnterEvent;
import com.vaadin.flow.router.BeforeEnterObserver;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;
import com.vaadin.flow.server.auth.AnonymousAllowed;
import org.hk.doghub.security.AuthenticatedUser;
import org.hk.doghub.ui.components.shared.user.UserCreationService;
import org.hk.doghub.ui.views.site.home.SiteHomeView;

@Route(SignupView.ROUTE)
@PageTitle(SignupView.NAME)
@AnonymousAllowed
public class SignupView extends VerticalLayout implements BeforeEnterObserver {

    public static final String ROUTE = "signup";
    private static final String ID_PREFIX = "signup";
    private static final String ID_SUFFIX = "-view";
    public static final String CLASS_NAME = ID_PREFIX + ID_SUFFIX;
    public static final String NAME = "Sign Up";

    private final AuthenticatedUser authenticatedUser;

    public SignupView(AuthenticatedUser authenticatedUser, UserCreationService userCreationService) {
        this.authenticatedUser = authenticatedUser;
        addClassName(CLASS_NAME);
        SignupContainer signupContainer = new SignupContainer(authenticatedUser, userCreationService);
        add(signupContainer);
        setSizeFull();
        setJustifyContentMode(JustifyContentMode.CENTER);
        setAlignItems(Alignment.CENTER);
    }

    @Override
    public void beforeEnter(BeforeEnterEvent event) {
        if (authenticatedUser.get().isPresent()) {
            event.forwardTo(SiteHomeView.class);
        }
    }
}
