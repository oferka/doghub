package org.hk.doghub.ui.views.site.profile;

import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;
import jakarta.annotation.security.RolesAllowed;
import lombok.extern.slf4j.Slf4j;
import org.hk.doghub.security.AuthenticatedUser;
import org.hk.doghub.ui.components.shared.UserCreationService;
import org.hk.doghub.ui.components.shared.UserInfoContainer;
import org.hk.doghub.ui.components.shared.UserInfoSaveEvent;
import org.hk.doghub.ui.components.shared.UserInfoSaveListener;
import org.hk.doghub.ui.views.app.users.UsersDataProvider;
import org.hk.doghub.ui.views.site.layout.DogHubSiteLayout;

import static com.vaadin.flow.component.orderedlayout.FlexComponent.Alignment.CENTER;

@Slf4j
@Route(value = ProfileView.ROUTE, layout = DogHubSiteLayout.class)
@PageTitle(ProfileView.NAME)
@RolesAllowed({"USER", "ADMIN"})
public class ProfileView extends VerticalLayout implements UserInfoSaveListener {

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
        if(authenticatedUser.get().isPresent()) {
            userInfo.setUser(authenticatedUser.get().get().getId());
        }
        userInfo.addUserInfoSaveListener(this);
        add(userInfo);
    }

    @Override
    public void saveTriggered(UserInfoSaveEvent event) {
        userInfo.save();
    }
}
