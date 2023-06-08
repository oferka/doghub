package org.hk.doghub.ui.views.site.profile;

import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;
import jakarta.annotation.security.RolesAllowed;
import lombok.extern.slf4j.Slf4j;
import org.hk.doghub.model.user.DogHubUser;
import org.hk.doghub.security.AuthenticatedUser;
import org.hk.doghub.ui.components.shared.*;
import org.hk.doghub.ui.components.shared.user.UserInfoContainer;
import org.hk.doghub.ui.components.shared.user.UserUpdateParameters;
import org.hk.doghub.ui.components.shared.user.UserUpdateService;
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

    private final EntityInfoContainer<DogHubUser, UserUpdateParameters> entityInfo;

    public ProfileView(UserDataProvider userDataProvider, AuthenticatedUser authenticatedUser, UserUpdateService userUpdateService) {
        addClassName(CLASS_NAME);
        setAlignItems(CENTER);

        entityInfo = new UserInfoContainer(userDataProvider, userUpdateService);
        if(authenticatedUser.get().isPresent()) {
            entityInfo.setEntity(authenticatedUser.get().get().getId());
        }
        entityInfo.addInfoSaveListener(this);
        entityInfo.addInfoCancelListener(this);
        add(entityInfo);
    }

    @Override
    public void saveTriggered(InfoSaveEvent event) {
        entityInfo.save();
    }

    @Override
    public void cancelTriggered(InfoCancelEvent event) {
        entityInfo.cancel();
    }
}
