package org.hk.doghub.ui.views.app.users.user;

import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.BeforeEvent;
import com.vaadin.flow.router.HasUrlParameter;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;
import jakarta.annotation.security.RolesAllowed;
import lombok.extern.slf4j.Slf4j;
import org.hk.doghub.model.user.DogHubUser;
import org.hk.doghub.security.AuthenticatedUser;
import org.hk.doghub.ui.components.shared.*;
import org.hk.doghub.ui.components.shared.user.UserUpdateService;
import org.hk.doghub.ui.views.app.layout.DogHubAppLayout;
import org.hk.doghub.ui.views.app.users.UserDataProvider;
import org.hk.doghub.ui.views.app.users.UsersView;

import static com.vaadin.flow.component.orderedlayout.FlexComponent.Alignment.CENTER;

@Slf4j
@Route(value = UsersView.ROUTE, layout = DogHubAppLayout.class)
@PageTitle(UserView.NAME)
@RolesAllowed({"ADMIN"})
public class UserView extends VerticalLayout implements HasUrlParameter<Long>, InfoSaveListener, InfoCancelListener {

    public static final String ID_PREFIX = "user";
    public static final String ID_SUFFIX = "-view";
    public static final String CLASS_NAME = ID_PREFIX + ID_SUFFIX;
    public static final String NAME = "User";

    private final EntityViewHeader<DogHubUser> header;
    private final UserViewBody body;
    private final EntityViewFooter<DogHubUser> footer;

    public UserView(UserDataProvider userDataProvider, AuthenticatedUser authenticatedUser, UserUpdateService userUpdateService) {
        addClassName(CLASS_NAME);

        setAlignItems(CENTER);

        header = new EntityViewHeader<>(userDataProvider);
        add(header);

        body = new UserViewBody(userDataProvider, userUpdateService);
        body.addInfoSaveListener(this);
        body.addInfoCancelListener(this);
        addAndExpand(body);

        footer = new EntityViewFooter<>(userDataProvider, authenticatedUser, UserView.NAME, UserView.class, UsersView.NAME, UsersView.class);
        add(footer);
    }

    @Override
    public void setParameter(BeforeEvent event, Long parameter) {
        setUser(parameter);
    }

    private void setUser(long selectedUserId) {
        header.selectedEntityChanged(selectedUserId);
        body.selectedUserChanged(selectedUserId);
        footer.selectedEntityChanged(selectedUserId);
    }

    @Override
    public void saveTriggered(InfoSaveEvent event) {
        header.save();
        body.save();
        footer.save();
    }

    @Override
    public void cancelTriggered(InfoCancelEvent event) {
        header.cancel();
        body.cancel();
        footer.cancel();
    }
}
