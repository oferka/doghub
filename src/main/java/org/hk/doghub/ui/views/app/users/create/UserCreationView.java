package org.hk.doghub.ui.views.app.users.create;

import com.vaadin.flow.component.icon.VaadinIcon;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;
import jakarta.annotation.security.RolesAllowed;
import jakarta.validation.constraints.NotNull;
import org.hk.doghub.model.user.DogHubUser;
import org.hk.doghub.security.AuthenticatedUser;
import org.hk.doghub.ui.components.shared.EntityCreationContainerForm;
import org.hk.doghub.ui.components.shared.EntityCreationService;
import org.hk.doghub.ui.components.shared.EntityCreationView;
import org.hk.doghub.ui.components.shared.user.UserCreationContainerForm;
import org.hk.doghub.ui.components.shared.user.UserCreationParameters;
import org.hk.doghub.ui.components.shared.user.UserCreationService;
import org.hk.doghub.ui.views.app.layout.DogHubAppLayout;
import org.hk.doghub.ui.views.app.users.UsersView;

import static com.vaadin.flow.component.icon.VaadinIcon.USERS;

@PageTitle(UserCreationView.NAME)
@Route(value = UserCreationView.ROUTE, layout = DogHubAppLayout.class)
@RolesAllowed({"ADMIN"})
public class UserCreationView extends EntityCreationView<DogHubUser, UserCreationParameters> {

    public static final String ROUTE = UsersView.ROUTE + "/create";
    private static final String ID_PREFIX = "user-creation";
    private static final String ID_SUFFIX = "-view";
    public static final String CLASS_NAME = ID_PREFIX + ID_SUFFIX;
    public static final String NAME = "User Creation";

    public UserCreationView(AuthenticatedUser authenticatedUser, UserCreationService creationService) {
        super(authenticatedUser, creationService);
        addClassName(CLASS_NAME);
    }

    @Override
    protected @NotNull VaadinIcon getHeaderIcon() {
        return USERS;
    }

    @Override
    protected @NotNull String getHeaderTitleText() {
        return "Create a User";
    }

    @Override
    protected @NotNull String getHeaderDescriptionText() {
        return "Add someone you love to DogHub";
    }

    @Override
    protected @NotNull EntityCreationContainerForm<DogHubUser, UserCreationParameters> getForm(AuthenticatedUser authenticatedUser, EntityCreationService<DogHubUser, UserCreationParameters> creationService) {
        return new UserCreationContainerForm(authenticatedUser, creationService);
    }
}
