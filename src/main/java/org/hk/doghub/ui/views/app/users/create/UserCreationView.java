package org.hk.doghub.ui.views.app.users.create;

import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;
import jakarta.annotation.security.RolesAllowed;
import org.hk.doghub.security.AuthenticatedUser;
import org.hk.doghub.ui.components.shared.EntityCreationViewHeader;
import org.hk.doghub.ui.components.shared.user.UserCreationService;
import org.hk.doghub.ui.views.app.layout.DogHubAppLayout;
import org.hk.doghub.ui.views.app.users.UsersView;

import static com.vaadin.flow.component.icon.VaadinIcon.USERS;

@PageTitle(UserCreationView.NAME)
@Route(value = UserCreationView.ROUTE, layout = DogHubAppLayout.class)
@RolesAllowed({"ADMIN"})
public class UserCreationView extends VerticalLayout {

    public static final String ROUTE = UsersView.ROUTE + "/create";
    private static final String ID_PREFIX = "user-creation";
    private static final String ID_SUFFIX = "-view";
    public static final String CLASS_NAME = ID_PREFIX + ID_SUFFIX;
    public static final String NAME = "User Creation";

    public UserCreationView(AuthenticatedUser authenticatedUser, UserCreationService userCreationService) {
        addClassName(CLASS_NAME);
        EntityCreationViewHeader header = new EntityCreationViewHeader(USERS, "Create a User", "Add someone you love to DogHub");
        add(header);
        UserCreationViewBody body = new UserCreationViewBody(authenticatedUser, userCreationService);
        addAndExpand(body);
        UserCreationViewFooter footer = new UserCreationViewFooter(authenticatedUser, userCreationService);
        add(footer);
    }
}
