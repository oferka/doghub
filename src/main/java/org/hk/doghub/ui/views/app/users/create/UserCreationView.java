package org.hk.doghub.ui.views.app.users.create;

import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;
import jakarta.annotation.security.RolesAllowed;
import org.hk.doghub.security.AuthenticatedUser;
import org.hk.doghub.ui.views.app.layout.DogHubAppLayout;
import org.hk.doghub.ui.views.app.users.UsersView;

@PageTitle(UserCreationView.NAME)
@Route(value = UserCreationView.ROUTE, layout = DogHubAppLayout.class)
@RolesAllowed({"ADMIN"})
public class UserCreationView extends VerticalLayout {

    public static final String ROUTE = UsersView.ROUTE + "/create";
    public static final String ID_PREFIX = "user-creation";
    public static final String ID_SUFFIX = "-view";
    public static final String CLASS_NAME = ID_PREFIX + ID_SUFFIX;
    public static final String NAME = "User Creation";
    private final UserCreationViewHeader header;
    private final UserCreationViewBody body;
    private final UserCreationViewFooter footer;

    public UserCreationView(AuthenticatedUser authenticatedUser, UserCreationService userCreationService) {
        addClassName(CLASS_NAME);

        header = new UserCreationViewHeader(authenticatedUser, userCreationService);
        add(header);

        body = new UserCreationViewBody(authenticatedUser, userCreationService);
        addAndExpand(body);

        footer = new UserCreationViewFooter(authenticatedUser, userCreationService);
        add(footer);
    }
}
