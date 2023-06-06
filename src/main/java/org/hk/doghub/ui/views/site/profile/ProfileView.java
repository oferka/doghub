package org.hk.doghub.ui.views.site.profile;

import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;
import jakarta.annotation.security.RolesAllowed;
import lombok.extern.slf4j.Slf4j;
import org.hk.doghub.security.AuthenticatedUser;
import org.hk.doghub.ui.components.shared.InfoCancelEvent;
import org.hk.doghub.ui.components.shared.InfoCancelListener;
import org.hk.doghub.ui.components.shared.InfoSaveEvent;
import org.hk.doghub.ui.components.shared.InfoSaveListener;
import org.hk.doghub.ui.components.shared.user.UserCreationService;
import org.hk.doghub.ui.components.shared.user.UserInfoContainer;
import org.hk.doghub.ui.views.app.users.UserDataProvider;
import org.hk.doghub.ui.views.site.layout.DogHubSiteLayout;

import static com.vaadin.flow.component.orderedlayout.FlexComponent.Alignment.CENTER;

@Slf4j
@Route(value = ProfileView.ROUTE, layout = DogHubSiteLayout.class)
@PageTitle(ProfileView.NAME)
@RolesAllowed({"USER", "ADMIN"})
public class ProfileView extends VerticalLayout implements InfoSaveListener, InfoCancelListener {

    public static final String ROUTE = "profile";
    public static final String ID_PREFIX = "profile";
    public static final String ID_SUFFIX = "-view";
    public static final String CLASS_NAME = ID_PREFIX + ID_SUFFIX;
    public static final String NAME = "Profile";

    private final UserInfoContainer userInfo;

    public ProfileView(UserDataProvider userDataProvider, AuthenticatedUser authenticatedUser, UserCreationService userCreationService) {
        addClassName(CLASS_NAME);
        setAlignItems(CENTER);

        userInfo = new UserInfoContainer(userDataProvider, authenticatedUser, userCreationService);
        if(authenticatedUser.get().isPresent()) {
            userInfo.setUser(authenticatedUser.get().get().getId());
        }
        userInfo.addInfoSaveListener(this);
        userInfo.addInfoCancelListener(this);
        add(userInfo);
    }

    @Override
    public void saveTriggered(InfoSaveEvent event) {
        userInfo.save();
    }

    @Override
    public void cancelTriggered(InfoCancelEvent event) {
        userInfo.cancel();
    }
}
