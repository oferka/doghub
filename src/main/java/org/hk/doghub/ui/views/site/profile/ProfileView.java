package org.hk.doghub.ui.views.site.profile;

import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;
import jakarta.annotation.security.RolesAllowed;
import org.hk.doghub.security.AuthenticatedUser;
import org.hk.doghub.ui.components.shared.UserCreationService;
import org.hk.doghub.ui.components.shared.UserInfoContainer;
import org.hk.doghub.ui.views.app.users.UsersDataProvider;
import org.hk.doghub.ui.views.site.layout.DogHubSiteLayout;

import static com.vaadin.flow.component.orderedlayout.FlexComponent.Alignment.CENTER;

@Route(value = ProfileView.ROUTE, layout = DogHubSiteLayout.class)
@PageTitle(ProfileView.NAME)
@RolesAllowed({"USER", "ADMIN"})
public class ProfileView extends VerticalLayout {

    public static final String ROUTE = "profile";
    public static final String ID_PREFIX = "profile";
    public static final String ID_SUFFIX = "-view";
    public static final String CLASS_NAME = ID_PREFIX + ID_SUFFIX;
    public static final String NAME = "Profile";

    private final UserInfoContainer userInfo;

    public ProfileView(UsersDataProvider usersDataProvider, AuthenticatedUser authenticatedUser, UserCreationService userCreationService) {
        addClassName(CLASS_NAME);
        setAlignItems(CENTER);

        userInfo = new UserInfoContainer(usersDataProvider, authenticatedUser, userCreationService);
        userInfo.selectedUserChanged(authenticatedUser.get().get().getId());
        add(userInfo);
    }
}
